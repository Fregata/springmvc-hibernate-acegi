package com.business.web.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClazzVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6755792091514880246L;
	private String id;
	private String name;
	private String code;
	private List<SubjectVO> subList;
	
	public ClazzVO(String name,String code){
		this.setName(name);
		this.setCode(code);
	}
	
	public ClazzVO(String id, String code, String name) {
		this.id = id;
		this.name = name;
		this.code = code;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
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

	public List<SubjectVO> getSubList() {
		if(subList==null){
			subList = new ArrayList<SubjectVO>();
		}
		return subList;
	}

	public void setSubList(List<SubjectVO> subList) {
		this.subList = subList;
	}
	
	
}
