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
	
	public ProfileInfo(String schoolName, String schoolCode){
		this.scl_SchoolRoll = new SchoolRoll();
		this.scl_SchoolRoll.setCode(schoolCode);
		this.scl_SchoolRoll.setName(schoolName);
		this.scl_SchoolRoll.setLevel("完中");
		this.scl_SchoolRoll.setProp("公办");
	
		
		//school
		this.school = new School();
		this.school.setSchoolRoll(this.scl_SchoolRoll);
		
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
			sch1.setCode(schoolCode+"0"+i);
			sch1.setName(schoolName+name);
			sch1.setParentId(this.scl_SchoolRoll.getId());
			Grade gd1 = new Grade();
			gd1.setName(name);
			gd1.setSchoolRoll(sch1);
			
			GradeInfo gi = new GradeInfo(sch1,gd1);
			this.getGradeInfoList().add(gi);
			
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
				sch2.setCode(schoolCode+"0"+i+"0"+j);
				sch2.setName(schoolName+clazzName);
				sch2.setParentId(sch1.getId());
				Clazz clazz = new Clazz();
				clazz.setName(clazzName);
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
