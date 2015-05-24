package com.business.persistence.vo;

import java.util.HashSet;
import java.util.Set;

public class SchoolRoll {

	private Integer id;
	private String name;
	private String code;
	private String level;
	private String prop;
	private Integer parentId;
	private Set<Subject> subjects = new HashSet<Subject>();
	private Set<Geograph> addresses = new HashSet<Geograph>();
	
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
	
	
}
