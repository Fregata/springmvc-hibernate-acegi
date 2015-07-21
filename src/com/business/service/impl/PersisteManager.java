package com.business.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.business.persistence.vo.Geograph;
import com.business.persistence.vo.School;
import com.business.persistence.vo.SchoolRoll;
import com.business.persistence.vo.Student;
import com.business.persistence.vo.StudentActivity;
import com.business.persistence.vo.Subject;
import com.business.persistence.vo.SubjectActivity;
import com.business.persistence.vo.Teacher;
import com.business.persistence.vo.TeacherActivity;
import com.business.service.IPersisteManager;
import com.business.web.vo.ClazzInfo;
import com.business.web.vo.GradeInfo;
import com.business.web.vo.GradeVO;
import com.business.web.vo.ProfileInfo;
import com.business.web.vo.StudentExcelVO;
import com.business.web.vo.SubjectVO;
import com.business.web.vo.TeacherExcelVO;
import com.framework.service.IBaseService;
import com.framework.util.bean.StringUtil;

@Service
public class PersisteManager implements IPersisteManager,ApplicationContextAware{

	private SessionFactory sessionFactory = null;
	private ApplicationContext applicationContext = null;
	private ThreadLocal<Session> sessions = new ThreadLocal<Session>();
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
		this.sessionFactory = (SessionFactory)applicationContext.getBean("sessionFactory");
	}

	public ApplicationContext getApplicationContext(){
		return this.applicationContext;
	}
	
	public Object getStaticBean(String name){
		return this.applicationContext.getBean(name);
	} 
	
	public Session currentSession() throws HibernateException{
		Session s = (Session)sessions.get();
		if(s==null){
			s = this.sessionFactory.openSession();
			sessions.set(s);
		}
		return s;
	}
	
	public void closeSession()throws HibernateException{
		Session s = (Session)sessions.get();
		if(s!=null){
			s.close();
			sessions.set(null);
		}
	}

	public boolean saveProfileInfo(ProfileInfo pi) {
		boolean isSuccess = true;
		Session session = null;
		Transaction tx = null;
		try{
			session = this.currentSession();
			tx = session.beginTransaction();
			
			Geograph geo = pi.getGeograph();
			SchoolRoll schoolRoll = pi.getScl_SchoolRoll();
			schoolRoll.getAddresses().add(geo);
			geo.getSchoolRolles().add(schoolRoll);
			
			session.persist(schoolRoll);
			session.update(geo);
			session.persist(pi.getSchool());
			
			for(GradeInfo gi:pi.getGradeInfoList()){
				SchoolRoll sch1 = gi.getGrd_SchoolRoll();
				sch1.setParentId(schoolRoll.getId());
				session.persist(sch1);
				session.persist(gi.getGrade());
			}
			
			for(ClazzInfo ci:pi.getClazzInfoList()){
				SchoolRoll sch2 = ci.getClz_SchoolRoll();
				for(GradeInfo gi:pi.getGradeInfoList()){
					SchoolRoll sch1 = gi.getGrd_SchoolRoll();
					String sch1Code = sch1.getCode();
					if(sch2.getCode().startsWith(sch1Code.substring(0, sch1Code.length()-1))){
						sch2.setParentId(sch1.getId());
						break;
					}
				}
				session.persist(sch2);
				session.persist(ci.getClazz());
			}
			tx.commit();
		}catch(Exception e){
			isSuccess = false;
			if(tx!=null){
				tx.rollback();
			}
			System.out.println(e.getMessage());
		}finally{
			this.closeSession();
		}
		
		return isSuccess;
	}

	public boolean saveSubjectInfo(School school, List<GradeVO> gradeList) {
		boolean isSuccess = true;
		Session session = null;
		Transaction tx = null;
		IBaseService iBaseService = (IBaseService)this.getStaticBean("IBaseService");
		try{
			session = this.currentSession();
			tx = session.beginTransaction();
			List<SchoolRoll> clzList = null;
			for(GradeVO g:gradeList){
				List<SubjectVO> subVOList = g.getSubList();
				clzList = iBaseService.findByLike(SchoolRoll.class, "parentId", g.getCode());
				if(clzList!=null&&clzList.size()>0){
					for(SchoolRoll clz:clzList){
						Set<Subject> subjects = clz.getSubjects();
						for(SubjectVO s:subVOList){
							if(isInDB(subjects,s)) continue;
							Subject sub = new Subject();
							sub.setName(s.getName());
							sub.setCode(s.getCode());
							sub.setSchoolRoll(clz);
							clz.getSubjects().add(sub);
							session.saveOrUpdate(sub);
						}
						session.saveOrUpdate(clz);
					}
				}
			}
			tx.commit();
		}catch(Exception e){
			isSuccess = false;
			if(tx!=null){
				tx.rollback();
			}
			System.out.println(e.getMessage());
		}finally{
			this.closeSession();
		}
		
		return isSuccess;
	}

	private boolean isInDB(Set<Subject> subjects,SubjectVO s) {
		for(Subject sub:subjects){
			if(s.getCode().equals(sub.getCode())) return true;
		}
		return false;
	}

	public boolean saveTeacherInfo(List<TeacherExcelVO> teData) {
		boolean isSuccess = true;
		Session session = null;
		Transaction tx = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		IBaseService iBaseService = (IBaseService)this.getStaticBean("IBaseService");
		try{
			session = this.currentSession();
			tx = session.beginTransaction();
			for(TeacherExcelVO t:teData){
				SchoolRoll clz = iBaseService.load(SchoolRoll.class, Integer.valueOf(t.getClassID()));
				Subject subject = null;
				Date birthDate = StringUtil.isEmpty(t.getTeaBirthDate())?null:df.parse(t.getTeaBirthDate());
				Date onboardDate = StringUtil.isEmpty(t.getTeaOnboardDate())?null:df.parse(t.getTeaOnboardDate());
				Date deboardDate = StringUtil.isEmpty(t.getTeaDeboardDate())?null:df.parse(t.getTeaDeboardDate());
				Date startDate = StringUtil.isEmpty(t.getStartDate())?null:df.parse(t.getStartDate());
				Date finishDate = StringUtil.isEmpty(t.getFinishDate())?null:df.parse(t.getFinishDate());
				Teacher teacher = new Teacher(t.getTeaCode(),t.getTeaName(),t.getTeaGender(),birthDate,t.getTeaPhone(),t.getTeaEmail(),
						t.getTeaIDCard(),t.getTeaEthinc(),t.getTeaNativePlace(),t.getTeaCollege(),t.getTeaMajor(),t.getTeaDegree(),t.getTeaStatus(),
						t.getTeaCertificate(),t.getTeaPostProp(),t.getTeaJobTitle(),t.getTeaPosition(),onboardDate,
						deboardDate,t.getTeaAddress(),t.getTeaZipCode(),t.getTeaTelNo(),t.getTeaIMNo(),t.getTeaRemark());
				if(clz != null){
					List<Subject> subjects = (List<Subject>)iBaseService.find("from Subject as s where s.schoolRoll.id="+String.valueOf(clz.getId())
							+" and s.code='"+t.getSubjectID()+"'");
					if(subjects.size()>0) subject = subjects.get(0);
					if(subject == null){
						throw new Exception("Can not find subject in database,subject code="+t.getSubjectID());
					}
				}else{
					throw new Exception("Can not find schoolroll in database,schoolroll id="+t.getClassID());
				}
				session.saveOrUpdate(teacher);
				session.saveOrUpdate(subject);
				TeacherActivity tAct = new TeacherActivity(startDate,finishDate,teacher,clz);
				SubjectActivity sAct = new SubjectActivity(startDate,finishDate,subject,teacher);
				session.saveOrUpdate(tAct);
				session.saveOrUpdate(sAct);
				teacher.setSubActivity(sAct);
				teacher.setTeaActivity(tAct);
			}
			tx.commit();
		}catch(Exception e){
			isSuccess = false;
			if(tx!=null){
				tx.rollback();
			}
			System.out.println(e.getMessage());
		}finally{
			this.closeSession();
		}
		return isSuccess;
	}

	public boolean saveStudentInfo(List<StudentExcelVO> stData) {
		boolean isSuccess = true;
		Session session = null;
		Transaction tx = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		IBaseService iBaseService = (IBaseService)this.getStaticBean("IBaseService");
		try{
			session = this.currentSession();
			tx = session.beginTransaction();
			for(StudentExcelVO s:stData){
				SchoolRoll clz = iBaseService.load(SchoolRoll.class, Integer.valueOf(s.getClassID()));
				Date birthDate = StringUtil.isEmpty(s.getStuBirthDate())?null:df.parse(s.getStuBirthDate());
				Date onboardDate = StringUtil.isEmpty(s.getStuOnboardDate())?null:df.parse(s.getStuOnboardDate());
				Date deboardDate = StringUtil.isEmpty(s.getStuDeboardDate())?null:df.parse(s.getStuDeboardDate());
				Date startDate = StringUtil.isEmpty(s.getStartDate())?null:df.parse(s.getStartDate());
				Date finishDate = StringUtil.isEmpty(s.getFinishDate())?null:df.parse(s.getFinishDate());
				Student student = new Student(s.getStuCode(), s.getStuName(), s.getStuGender(), birthDate,
						s.getStuPhone(), s.getStuEmail(), s.getStuRollNo(), s.getStuNative(),
						s.getStuIDCard(), s.getStuAddress(), s.getStuZipCode(), s.getStuStatus(),
						s.getStuFamilyType(), s.getStuKnowledgeLevel(), s.getStuOriginAttr(),
						s.getStuPosition(), onboardDate, deboardDate, s.getStuEthinc(),
						s.getStuBloodCatalog(), s.getStuNativeAddress(), s.getStuNativeZipCode(),
						s.getStuTelNo(), s.getStuIMNo(), s.getStuRemark());
				if(clz == null){
					throw new Exception("Can not find schoolroll in database,schoolroll id="+s.getClassID());
				}
				session.saveOrUpdate(student);
				StudentActivity sAct = new StudentActivity(startDate,finishDate,student,clz);
				session.saveOrUpdate(sAct);
				student.setStuActivity(sAct);
			}
			tx.commit();
		}catch(Exception e){
			isSuccess = false;
			if(tx!=null){
				tx.rollback();
			}
			System.out.println(e.getMessage());
		}finally{
			this.closeSession();
		}
		return isSuccess;
	}
	

}
