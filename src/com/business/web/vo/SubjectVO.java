package com.business.web.vo;

import java.io.Serializable;

public class SubjectVO implements Serializable {

	private static final long serialVersionUID = -4442862536423448253L;
	private String name;
	private String code;
	
	public SubjectVO(String name,String code){
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
	
	
}
