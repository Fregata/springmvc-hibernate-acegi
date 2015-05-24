/*
 * @(#)SelectBean.java
 *       
 * 功能描述：下拉框BEAN对象，用于处理国际化
 * 公用方法描述：
 * 
 * 修改人：
 * 修改日期：
 * 修改原因：
 * 
 * 
 */
package com.framework.util.bean;
 
public class SelectBean {	
	
	private String code;
	private String value;
	
	public SelectBean(){		
	}
	
	public SelectBean(String code,String value){
		this.code = code;
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String toString(){ 
		return "[code=" + code + ",value" + value + "]";
	} 
}
