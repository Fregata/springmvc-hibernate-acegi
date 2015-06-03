package com.business.web.vo;

import java.io.Serializable;

import com.business.persistence.vo.Grade;
import com.business.persistence.vo.SchoolRoll;

public class GradeInfo implements Serializable {

	private static final long serialVersionUID = 1779845244556830670L;

	private SchoolRoll grd_SchoolRoll;
	private Grade grade;
	
	public GradeInfo(SchoolRoll sch, Grade grd){
		this.setGrd_SchoolRoll(sch);
		this.setGrade(grd);
	}
	
	public SchoolRoll getGrd_SchoolRoll() {
		return grd_SchoolRoll;
	}
	public void setGrd_SchoolRoll(SchoolRoll grd_SchoolRoll) {
		this.grd_SchoolRoll = grd_SchoolRoll;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	
}
