package com.business.persistence.vo;

import java.io.Serializable;

public class Grade implements Serializable{

	private static final long serialVersionUID = 259690919739905921L;
	private Integer id;
	private String name;
	private SchoolRoll schoolRoll;


	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SchoolRoll getSchoolRoll() {
		return schoolRoll;
	}
	public void setSchoolRoll(SchoolRoll schoolRoll) {
		this.schoolRoll = schoolRoll;
	}

	
}
