package com.business.persistence.vo;

import java.io.Serializable;
import java.util.Date;

public class TeacherActivity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8089929407647923282L;
	private Integer id;
	private Date startDate;
	private Date finishDate;
	private Teacher teacher;
	private SchoolRoll schoolRoll;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public SchoolRoll getSchoolRoll() {
		return schoolRoll;
	}
	public void setSchoolRoll(SchoolRoll schoolRoll) {
		this.schoolRoll = schoolRoll;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
}
