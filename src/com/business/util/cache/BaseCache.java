package com.business.util.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.business.persistence.vo.Geograph;
import com.business.util.CacheUtil;
import com.business.web.vo.City;
import com.business.web.vo.District;
import com.business.web.vo.Province;
import com.framework.service.IBaseService;


public class BaseCache implements ApplicationContextAware{

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		baseService = (IBaseService)applicationContext.getBean("IBaseService"); 
		init();
	}

	private static IBaseService baseService = null; 
	
	public static void init() {
		try {
			buildGeographCache();
		}catch(Exception e) {
			
		}
	}

	public static void buildGeographCache() {
		Map geoCache = CacheUtil.getCache(CacheUtil.GEOGRAPH_CACHE);
		List provinceList = baseService.find("from Geograph g where g.level=1");
		buildProvinceCache(provinceList);
		
		List<Province> pList = new ArrayList<Province>();
		for(Object o1:provinceList){//iterate province level
			Geograph g1 = (Geograph)o1;
			Province p = new Province(g1.getBinCode(),g1.getName());
			List cityList = baseService.find("from Geograph g where g.parentId="+g1.getId());
			buildCityCache(cityList);
			
			for(Object o2:cityList){//iterate city level
				Geograph g2 = (Geograph)o2;
				City c = new City(g2.getBinCode(),g2.getName());
				p.getCityList().add(c);
				List distList = baseService.find("from Geograph g where g.parentId="+g2.getId());
				buildDistrictCache(distList);
				
				for(Object o3:distList){//iterate district level
					Geograph g3 = (Geograph)o3;
					District d = new District(g3.getBinCode(),g3.getName());
					c.getDictList().add(d);
				}
			}
			pList.add(p);
		}
		
		for(Province p:pList){
			CacheUtil.addNameCode(geoCache, p.getCode(), p);
		}
	}
	
	public static void buildProvinceCache(List provinceList) {
		Map cache = CacheUtil.getCache(CacheUtil.PROVINCE_CACHE);
		for(Object o:provinceList){
			Geograph g = (Geograph)o;
			CacheUtil.addNameCode(cache, g.getBinCode(), g);
		}
	}
	
	public static void buildCityCache(List cityList) {
		Map cache = CacheUtil.getCache(CacheUtil.CITY_CACHE);
		for(Object o:cityList){
			Geograph g = (Geograph)o;
			CacheUtil.addNameCode(cache, g.getBinCode(), g);
		}
	}
	
	public static void buildDistrictCache(List distList) {
		Map cache = CacheUtil.getCache(CacheUtil.DISTRICT_CACHE);
		for(Object o:distList){
			Geograph g = (Geograph)o;
			CacheUtil.addNameCode(cache, g.getBinCode(), g);
		}
	}
}
