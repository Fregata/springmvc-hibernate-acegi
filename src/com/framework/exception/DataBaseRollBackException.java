package com.framework.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

public class DataBaseRollBackException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2993602217446316794L;

	private String messageId;
	
    protected final Logger log = Logger.getLogger(this.getClass().getName());
	
    public DataBaseRollBackException() {
		super();
	}

	public DataBaseRollBackException(Throwable cause) {
		super(cause);
		log.error(cause.getStackTrace());
	}

	public DataBaseRollBackException(String message, Throwable cause) {
		super(message, cause);
		log.error("msg:" + message + "  " + cause.getStackTrace());
	}

	public DataBaseRollBackException(String id) {
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

