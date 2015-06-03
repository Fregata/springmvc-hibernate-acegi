package com.business.web.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class City implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8502306618211792442L;

	private String code;
	private String name;
	private List<District> dictList;
	
	public City(String code,String name){
		this.setCode(code);
		this.setName(name);
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<District> getDictList() {
		if(dictList==null){
			dictList = new ArrayList<District>();
		}
		return dictList;
	}
	public void setDictList(List<District> dictList) {
		this.dictList = dictList;
	}
	
}
