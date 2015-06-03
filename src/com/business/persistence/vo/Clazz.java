package com.business.persistence.vo;

import java.io.Serializable;

public class Clazz implements Serializable{

	private static final long serialVersionUID = -7488928706907789162L;
	
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
