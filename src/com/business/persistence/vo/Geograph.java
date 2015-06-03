package com.business.persistence.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Geograph implements Serializable{
	private static final long serialVersionUID = -4517697105396075379L;
	private Integer id;
	private String name;
	private Integer level;
	private String binCode;
	private String strCode;
	private Integer parentId;
	private Set<SchoolRoll> schoolRolles = new HashSet<SchoolRoll>();
	
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
	
	public String getBinCode() {
		return binCode;
	}
	
	public void setBinCode(String binCode) {
		this.binCode = binCode;
	}
	
	public String getStrCode() {
		return strCode;
	}
	
	public void setStrCode(String strCode) {
		this.strCode = strCode;
	}
	
	public Integer getParentId() {
		return parentId;
	}
	
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Set<SchoolRoll> getSchoolRolles() {
		return schoolRolles;
	}

	public void setSchoolRolles(Set<SchoolRoll> schoolRolles) {
		this.schoolRolles = schoolRolles;
	}
	
	
}
