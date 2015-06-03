package com.business.persistence.vo;

import java.io.Serializable;

public class Subject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8008929627857487696L;
	private Integer id;
	private String name;
	private String code;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public SchoolRoll getSchoolRoll() {
		return schoolRoll;
	}
	public void setSchoolRoll(SchoolRoll schoolRoll) {
		this.schoolRoll = schoolRoll;
	}

	
}
