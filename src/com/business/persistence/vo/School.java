package com.business.persistence.vo;

import java.io.Serializable;

public class School implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5235651693999063911L;
	private Integer id;
	private String name;
	private String level;
	private String prop;
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
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getProp() {
		return prop;
	}
	public void setProp(String prop) {
		this.prop = prop;
	}
	public SchoolRoll getSchoolRoll() {
		return schoolRoll;
	}
	public void setSchoolRoll(SchoolRoll schoolRoll) {
		this.schoolRoll = schoolRoll;
		this.name=schoolRoll.getName();
		this.level=schoolRoll.getLevel();
		this.prop=schoolRoll.getProp();
	}
	
	
}
