/*
 * @(#)Cache.java
 *       
 * 功能描述：定义缓存接口
 * 公用方法描述：
 * 
 * 修改人：
 * 修改日期：
 * 修改原因：
 * 
 * 
 */
package com.framework.util.cache;

import com.framework.exception.BaseSysException;

public interface Cache {
	Object get(Object key) throws BaseSysException;

	void put(Object key, Object value) throws BaseSysException;

	void remove(Object key) throws BaseSysException;

	void clear() throws BaseSysException;

	void destroy() throws BaseSysException;  
	
	/**
	 * OSCache清除缓存时，并没有改变缓存大小而只是把数据项置为过期，所以缓存的长度不变
	 * 所以这个方法无法表达真实的缓存大小 
	 * @return
	 * @throws BaseSysException
	 */
	public int getSize() throws BaseSysException;
}
