package com.business.persistence.vo;

import java.io.Serializable;
import java.util.Date;

public class SubjectActivity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8940497244643294189L;
	private Integer id;
	private Date startDate;
	private Date finishDate;
	private Subject subject;
	private Teacher teacher;
	
	public SubjectActivity() {}
	
	public SubjectActivity(Date startDate, Date finishDate, Subject subject,
			Teacher teacher) {
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.subject = subject;
		this.teacher = teacher;
	}
	
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
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
}
