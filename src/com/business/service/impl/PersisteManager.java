package com.business.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.business.persistence.vo.Geograph;
import com.business.persistence.vo.SchoolRoll;
import com.business.service.IPersisteManager;
import com.business.web.vo.ClazzInfo;
import com.business.web.vo.GradeInfo;
import com.business.web.vo.ProfileInfo;

@Service
public class PersisteManager implements IPersisteManager,ApplicationContextAware{

	private SessionFactory sessionFactory = null;
	private ApplicationContext applicationContext = null;
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
		this.sessionFactory = (SessionFactory)applicationContext.getBean("sessionFactory");
	}

	public ApplicationContext getApplicationContext(){
		return this.applicationContext;
	}
	
	public Object getBean(String name){
		return this.applicationContext.getBean(name);
	} 
	
	public void saveProfileInfo(ProfileInfo pi) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Geograph geo = pi.getGeograph();
		SchoolRoll schoolRoll = pi.getScl_SchoolRoll();
		schoolRoll.getAddresses().add(geo);
		geo.getSchoolRolles().add(schoolRoll);
		
		session.update(geo);
		session.persist(schoolRoll);
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
				if(sch2.getCode().startsWith(sch1.getCode())){
					sch2.setParentId(sch1.getId());
					break;
				}
			}
			session.persist(sch2);
			session.persist(ci.getClazz());
		}
		
		tx.commit();
		session.close();
	}
	
	

}
