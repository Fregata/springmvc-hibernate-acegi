package com.business.persistence.vo;

import java.io.Serializable;
import java.util.Date;

public class StudentActivity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -977817581995597259L;
	private Integer id;
	private Date startDate;
	private Date finishDate;
	private Student student;
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
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public SchoolRoll getSchoolRoll() {
		return schoolRoll;
	}
	public void setSchoolRoll(SchoolRoll schoolRoll) {
		this.schoolRoll = schoolRoll;
	}
	
	
}
