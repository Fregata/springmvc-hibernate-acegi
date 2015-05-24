package com.business.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.business.persistence.vo.Clazz;
import com.business.persistence.vo.Geograph;
import com.business.persistence.vo.Grade;
import com.business.persistence.vo.School;
import com.business.persistence.vo.SchoolRoll;

public class PersitTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/META-INF/applicationContext-beans.xml");
		SessionFactory sf = (SessionFactory)ctx.getBean("sessionFactory");
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//IBaseService bs = (IBaseService)ctx.getBean("IBaseService");
		//address
		Geograph g = new Geograph();
		g.setBinCode("31");
		g.setName("上海市");
		g.setParentId(0);
		g.setLevel(1);
		g.setStrCode("SHA");
		
		//schoolroll
		SchoolRoll sch = new SchoolRoll();
		sch.setCode("00001");
		sch.setName("上师大附属第二实验学校");
		sch.setLevel("完中");
		sch.setProp("公办");
		
		sch.getAddresses().add(g);
		g.getSchoolRolles().add(sch);
		session.persist(g);
		session.persist(sch);
		
		//school
		School scl = new School();
		scl.setSchoolRoll(sch);
		session.persist(scl);
		
		//class
		for(int i=1;i<4;i++){//three grade each school
			String name = null;
			switch(i){
				case 1:
					name="初一年级";
					break;
				case 2:
					name="初二年级";
					break;
				case 3:
					name="初三年级";
					break;
				default:
					break;
			}
			SchoolRoll sch1 = new SchoolRoll();
			sch1.setCode("000010"+i);
			sch1.setName("上师大附属第二实验学校"+name);
			sch1.setParentId(sch.getId());
			Grade gd1 = new Grade();
			gd1.setName(name);
			gd1.setSchoolRoll(sch1);
			
			session.persist(sch1);
			session.persist(gd1);
			
			for(int j=1;j<6;j++){//five class each grade
				String clazzName = null;
				switch(j){
					case 1:
						clazzName=name+"(1)班";
						break;
					case 2:
						clazzName=name+"(2)班";
						break;
					case 3:
						clazzName=name+"(3)班";
						break;
					case 4:
						clazzName=name+"(4)班";
						break;
					case 5:
						clazzName=name+"(5)班";
						break;
					default:
						break;
			    }
				SchoolRoll sch2 = new SchoolRoll();
				sch2.setCode("000010"+i+"0"+j);
				sch2.setName("上师大附属第二实验学校"+clazzName);
				sch2.setParentId(sch1.getId());
				Clazz clazz = new Clazz();
				clazz.setName(clazzName);
				clazz.setSchoolRoll(sch2);
				session.persist(sch2);
				session.persist(clazz);
			}
		}
		
		//subject
		
		tx.commit();
		session.close();
	}

}
