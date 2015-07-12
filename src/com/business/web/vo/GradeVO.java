package com.business.web.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class GradeVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6182536705203426335L;
	private String name;
	private String code;
	private List<ClazzVO> clzList;
	private List<SubjectVO> subList;
	
	public GradeVO(String name,String code){
		this.setName(name);
		this.setCode(code);
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
	
	public List<ClazzVO> getClzList() {
		if(this.clzList==null){
			this.clzList = new ArrayList<ClazzVO>();
		}
		return clzList;
	}
	
	public void setClzList(List<ClazzVO> clzList) {
		this.clzList = clzList;
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
