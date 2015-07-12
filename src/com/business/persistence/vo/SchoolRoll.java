package com.business.persistence.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class SchoolRoll implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1631434737236882548L;
	private Integer id;
	private String name;
	private String code;
	private String type;
	private String level;
	private String prop;
	private String address;
	private Integer parentId;
	private Set<Subject> subjects = new HashSet<Subject>();
	private Set<Geograph> addresses = new HashSet<Geograph>();
	
	public SchoolRoll() {
		
	}

	public SchoolRoll(String name, String code, String type, String level,
			String prop, String address) {
		this.name = name;
		this.code = code;
		this.type = type;
		this.level = level;
		this.prop = prop;
		this.address = address;
	}
	
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
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Set<Geograph> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Geograph> addresses) {
		this.addresses = addresses;
	}
	public Set<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
