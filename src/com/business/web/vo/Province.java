package com.business.web.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Province implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 100820097238070590L;

	private String code;
	private String name;
	private List<City> cityList;
	
	public Province(String code,String name){
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
	public List<City> getCityList() {
		if(cityList==null){
			cityList = new ArrayList<City>();
		}
		return cityList;
	}
	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}
	
	
}
