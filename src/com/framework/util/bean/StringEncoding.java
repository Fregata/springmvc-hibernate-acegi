/*
 * @(#)StringEncoding.java
 *       
 * 功能描述：字符串加密工具类
 * 公用方法描述：
 * 
 * 修改人：
 * 修改日期：
 * 修改原因：
 * 
 * 
 */
package com.framework.util.bean;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.Random;

import org.apache.log4j.Logger;

/**
 * String Utility Class This is used to encode passwords programmatically
 *   
 * @author   
 * @version  
 */
public class StringEncoding { 
 
	//private static Log log = LogFactory.getLog(StringEncoding.class); 
	//2010-01-13 修改人：liuningyi 由于WAS7不支持LogFactory，故改为这种方式直接加载log
    private static Logger log = Logger.getLogger(StringEncoding.class.getName());
	/**
	 * Encode a string using algorithm specified in web.xml and return the
	 * resulting encrypted password. If exception, the plain credentials string
	 * is returned
	 * 
	 * @param password   Password or other credentials to use in authenticating this username
	 * @param algorithm  Algorithm used to do the digest
	 * 
	 * @return encypted  password based on the algorithm.
	 */
	public static String encodePassword(String password, String algorithm) {
		byte[] unencodedPassword = password.getBytes();

		MessageDigest md = null;

		try {
			// first create an instance, given the provider
			md = MessageDigest.getInstance(algorithm);
		} catch (Exception e) {
			log.error("Exception: " + e);
			return password;
		}

		md.reset(); 
		md.update(unencodedPassword);

		// now calculate the hash
		byte[] encodedPassword = md.digest();
		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < encodedPassword.length; i++) {
			if (((int) encodedPassword[i] & 0xff) < 0x10) {
				buf.append("0");
			} 
			buf.append(Long.toString((int) encodedPassword[i] & 0xff, 16));
		} 
		return buf.toString();
	}

	/**
	 * Encode a string using Base64 encoding. Used when storing passwords as
	 * cookies.
	 * 
	 * This is weak encoding in that anyone can use the decodeString routine to
	 * reverse the encoding.
	 * 
	 * @param str
	 * @return String
	 */
	public static String encodeString(String str) {
		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
		return  encoder.encodeBuffer(str.getBytes()).trim();
	}

	/**
	 * Decode a string using Base64 encoding.
	 * 
	 * @param str
	 * @return String
	 */
	public static String decodeString(String str) {
		sun.misc.BASE64Decoder dec = new sun.misc.BASE64Decoder();
		try {
			return new String(dec.decodeBuffer(str));
		} catch (IOException io) {
			throw new RuntimeException(io.getMessage(), io.getCause());
		}
	}

	/**  
	 * @param str
	 * @return String
	 */
	public static String getRandPassword() { 
        String password = "000000" + new Random().nextInt(10000000);        
        return password.substring(password.length() - 6);
	} 
}