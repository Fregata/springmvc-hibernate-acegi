package com.business.web.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.business.persistence.vo.Clazz;
import com.business.persistence.vo.Geograph;
import com.business.persistence.vo.Grade;
import com.business.persistence.vo.School;
import com.business.persistence.vo.SchoolRoll;

public class ProfileInfo implements Serializable {

	private static final long serialVersionUID = -1158569601878639589L;

	private Geograph geograph;
	private SchoolRoll scl_SchoolRoll;
	private School school;
	
	private List<GradeInfo> gradeInfoList;
	private List<ClazzInfo> clazzInfoList;
	
	public ProfileInfo(String schoolName, String schoolCode,String schoolType,String schoolAttr,
			String schoolLevel,String schoolAddr,List<GradeVO> gradeList){
		this.scl_SchoolRoll = new SchoolRoll(schoolName, schoolCode, schoolType, schoolLevel,schoolAttr, schoolAddr);
		
		//school
		this.school = new School();
		this.school.setSchoolRoll(this.scl_SchoolRoll);
		
		//class
		for(GradeVO gra:gradeList){//three grade each school
			SchoolRoll sch1 = new SchoolRoll();
			sch1.setCode(schoolCode+gra.getCode());
			sch1.setName(schoolName+gra.getName());
			sch1.setParentId(this.scl_SchoolRoll.getId());
			Grade gd1 = new Grade();
			gd1.setName(gra.getName());
			gd1.setSchoolRoll(sch1);
			
			GradeInfo gi = new GradeInfo(sch1,gd1);
			this.getGradeInfoList().add(gi);
			
			for(ClazzVO clz:gra.getClzList()){//five class each grade
				SchoolRoll sch2 = new SchoolRoll();
				sch2.setCode(schoolCode+clz.getCode());
				sch2.setName(schoolName+clz.getName());
				sch2.setParentId(sch1.getId());
				Clazz clazz = new Clazz();
				clazz.setName(clz.getName());
				clazz.setSchoolRoll(sch2);
				
				ClazzInfo ci = new ClazzInfo(sch2,clazz);
				this.getClazzInfoList().add(ci);
			}
		}
	}
	
	public Geograph getGeograph() {
		return geograph;
	}
	public void setGeograph(Geograph geograph) {
		this.geograph = geograph;
	}
	public SchoolRoll getScl_SchoolRoll() {
		return scl_SchoolRoll;
	}
	public void setScl_SchoolRoll(SchoolRoll scl_SchoolRoll) {
		this.scl_SchoolRoll = scl_SchoolRoll;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public List<GradeInfo> getGradeInfoList() {
		if(gradeInfoList == null)
			gradeInfoList = new ArrayList<GradeInfo>();
		return gradeInfoList;
	}
	public void setGradeInfoList(List<GradeInfo> gradeInfoList) {
		this.gradeInfoList = gradeInfoList;
	}
	public List<ClazzInfo> getClazzInfoList() {
		if(clazzInfoList==null)
			clazzInfoList = new ArrayList<ClazzInfo>();
		return clazzInfoList;
	}
	public void setClazzInfoList(List<ClazzInfo> clazzInfoList) {
		this.clazzInfoList = clazzInfoList;
	}
	
	
	
}
