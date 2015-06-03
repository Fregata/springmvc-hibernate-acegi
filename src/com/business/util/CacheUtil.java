package com.business.util;

import java.util.HashMap;
import java.util.Map;

import com.framework.util.cache.CacheManager;
import com.framework.util.validate.ValidateUtil;

public class CacheUtil {

	public static String GEOGRAPH_CACHE="GEOGRAPH_CACHE";
	public static String PROVINCE_CACHE="PROVINCE_CACHE";
	public static String CITY_CACHE    ="CITY_CACHE";
	public static String DISTRICT_CACHE="DISTRICT_CACHE";
	
	public static Map getCache(String cacheName){ 
        Map cache = (Map)CacheManager.getCache("BASE_CACHE").get(cacheName); 
        if(cache == null){
        	cache = new HashMap();
        	CacheManager.getCache("BASE_CACHE").put(cacheName,cache);
        }
        return cache;
    } 
    
    public static void addNameCode(Map fndCache,String key,Object value){
    	if(ValidateUtil.isBlank(key))  
    		return;
    	fndCache.put(key.toUpperCase(), value);
    }
}
