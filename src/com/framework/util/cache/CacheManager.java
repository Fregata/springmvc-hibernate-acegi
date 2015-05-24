/*
 * @(#)CacheManager.java
 *       
 * 功能描述：缓存管理类
 * 公用方法描述：
 * 
 * 修改人：
 * 修改日期：
 * 修改原因：
 * 
 * 
 */
package com.framework.util.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.opensymphony.oscache.base.Config;

public class CacheManager {
	private static Map cacheMap = new HashMap();

	private static final Properties OSCACHE_PROPERTIES  = new Config().getProperties();

	private CacheManager() {
	}

	public static Cache getCache(Class clazz) {
		return getCache(clazz.getName());
	}

	public static Cache getCache(String cacheId) {
		Cache cache = null;
		cache = (Cache) cacheMap.get(cacheId);
		if (cache == null) {
			cache = new OSCache(OSCACHE_PROPERTIES);
			cacheMap.put(cacheId, cache);
		}
		return cache;
	}
}
