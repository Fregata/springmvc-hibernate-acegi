package com.framework.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

public class DataBaseQueryException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3370926468724858030L;

	private String messageId;
	
    protected final Logger log = Logger.getLogger(this.getClass().getName());
	
    public DataBaseQueryException() {
		super();
	}

	public DataBaseQueryException(Throwable cause) {
		super(cause);
		log.error(cause.getStackTrace());
	}

	public DataBaseQueryException(String message, Throwable cause) {
		super(message, cause);
		log.error("msg:" + message + "  " + cause.getStackTrace());
	}

	public DataBaseQueryException(String id) {
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
