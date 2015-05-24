package com.framework.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

public class ParametersErrorException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4929455336357953529L;

	private String messageId;
	
    protected final Logger log = Logger.getLogger(this.getClass().getName());
	
    public ParametersErrorException() {
		super();
	}

	public ParametersErrorException(Throwable cause) {
		super(cause);
		log.error(cause.getStackTrace());
	}

	public ParametersErrorException(String message, Throwable cause) {
		super(message, cause);
		log.error("msg:" + message + "  " + cause.getStackTrace());
	}

	public ParametersErrorException(String id) {
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
