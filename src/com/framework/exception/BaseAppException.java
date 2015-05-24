/*
 * @(#)BaseAppException.java
 *       
 * 功能描述：基础应用异常类Exception，在系统中需要catch
 * 公用方法描述：
 * 
 * 修改人：
 * 修改日期：
 * 修改原因：
 * 
 * 
 */ 
package com.framework.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.framework.util.validate.ValidateUtil;

public class BaseAppException extends Exception {

	private String messageId;

	public BaseAppException() {
	}

	public BaseAppException(Throwable cause) {
		super(cause);
	}

	public BaseAppException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseAppException(String id) {
		messageId = id;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String id) {
		messageId = id;
	}

	public String getStackTraceString() {

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		this.printStackTrace(pw);
		return sw.toString();
	}
	
	public String getMessage(){
		if(!ValidateUtil.isNullOrEmpty(getMessageId()))
			return getMessageId();
		
		if(!ValidateUtil.isNullOrEmpty(super.getMessage()))
			return super.getMessage();
		
		return this.toString();
	}
}
