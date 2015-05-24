/*
 * @(#)OSCache.java
 *       
 * 功能描述：OS缓存
 * 公用方法描述：
 * 
 * 修改人：
 * 修改日期：
 * 修改原因：
 * 
 * 
 */
package com.framework.util.cache;

import java.util.Properties;

import com.opensymphony.oscache.base.NeedsRefreshException;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;
import com.framework.exception.BaseSysException;

public class OSCache implements Cache {
	private GeneralCacheAdministrator cache = null;

	public OSCache(Properties prop) {
		cache = new GeneralCacheAdministrator(prop);
	}

	public void setCacheCapacity(int cacheCapacity) {
		cache.setCacheCapacity(cacheCapacity);
	}

	public Object get(Object key) throws BaseSysException {
		try {
			return cache.getFromCache(String.valueOf(key));
		} catch (NeedsRefreshException e) {
			cache.cancelUpdate(String.valueOf(key));
			return null;
		}
	}

	public void put(Object key, Object value) throws BaseSysException {
		cache.putInCache(String.valueOf(key), value);
	}

	public void remove(Object key) throws BaseSysException {
		cache.flushEntry(String.valueOf(key));
	}

	public void clear() throws BaseSysException {
		cache.flushAll();
	}

	public void destroy() throws BaseSysException {
		cache.destroy();
	}

	/**
	 * OSCache清除缓存时，并没有改变缓存大小而只是把数据项置为过期，所以缓存的长度不变
	 * 所以这个方法无法表达真实的缓存大小 
	 * @return
	 * @throws BaseSysException
	 */
	public int getSize() throws BaseSysException{
		return cache.getCache().getSize();
	}
}
