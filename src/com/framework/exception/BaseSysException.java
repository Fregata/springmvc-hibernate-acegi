/*
 * @(#)BaseSysException.java
 *       
 * 功能描述：基础系统异常类继承RuntimeException，在系统中无需catch
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

import org.apache.log4j.Logger;


public class BaseSysException extends RuntimeException {
	private String messageId;
	
	//static private Log log = LogFactory.getLog(BaseSysException.class);
	//2010-01-13 修改人：liuningyi 由于WAS7不支持LogFactory，故改为这种方式直接加载log
    protected final Logger log = Logger.getLogger(this.getClass().getName());
	
    public BaseSysException() {
		super();
	}

	public BaseSysException(Throwable cause) {
		super(cause);
		log.error(cause.getStackTrace());
	}

	public BaseSysException(String message, Throwable cause) {
		super(message, cause);
		log.error("msg:" + message + "  " + cause.getStackTrace());
	}

	public BaseSysException(String id) {
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
}
