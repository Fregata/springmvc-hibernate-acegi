/*
 * @(#)SortUtil.java
 *       
 * 功能描述：对Collection排序
 * 公用方法描述：
 * 
 * 修改人：
 * 修改日期：
 * 修改原因：
 * 
 * 
 */
package com.framework.util.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.framework.util.validate.ValidateUtil;

public class SortUtil { 
	public static String SORTTYPE_ASC  = "ASC";
	public static String SORTTYPE_DESC = "DESC";
	
	/**
	 * 对列表进行（升序）排序，comparator根据字段类型自动比较 
	 * @param list         需要排序的列表
	 * @param attribute    排序的字段
	 */
	public static void sortList(List list, String attribute) {	
		if(ValidateUtil.isBlank(attribute)) return;
		
		Comparator comparator = new PropertyComparator(attribute);    
		Collections.sort(list,comparator); 
	}

	/**
	 * 对列表进行排序，comparator根据字段类型自动比较 
	 * @param list         需要排序的列表
	 * @param attribute    排序的字段
	 * @param sortType     升序（ASC）或者降序（DSC），缺省为升序（ASC）
	 */
	public static void sortList(List list, String attribute,String sortType) {	
		if(ValidateUtil.isBlank(attribute)) return;
		if(ValidateUtil.isBlank(sortType)) sortType= "ASC";
		
		Comparator comparator = new PropertyComparator(attribute,sortType);    
		Collections.sort(list,comparator); 
	}
	
	
	
	
	/**
	 * 根据MAP的key排序
	 * @param m       待排序的MAP
	 * @return
	 */
	public static Map.Entry[] getSortedMapByKey(Map m,final String sortType){
		Set set = m.entrySet();
		Map.Entry[] entries = (Map.Entry[])set.toArray(new Map.Entry[set.size()]);
		
		Arrays.sort(entries,new Comparator(){
			public int compare(Object arg0,Object arg1){
				Object key1 = ((Map.Entry)arg0).getKey();
				Object key2 = ((Map.Entry)arg1).getKey();
				if(SORTTYPE_ASC.equals(sortType))
					return ((Comparable)key1).compareTo(key2);
				else
					return ((Comparable)key2).compareTo(key1);
			}
		});
		return entries;		
	}
	

	/**
	 * 根据MAP的value排序
	 * @param m         待排序的MAP
	 * @return
	 */
	public static Map.Entry[] getSortedMapByValue(Map m,final String sortType){
		Set set = m.entrySet();
		Map.Entry[] entries = (Map.Entry[])set.toArray(new Map.Entry[set.size()]);
		
		Arrays.sort(entries,new Comparator(){
			public int compare(Object arg0,Object arg1){
				Object value1 = ((Map.Entry)arg0).getValue();
				Object value2 = ((Map.Entry)arg1).getValue();
				if(SORTTYPE_ASC.equals(sortType))
					return ((Comparable)value1).compareTo(value2);
				else
					return ((Comparable)value2).compareTo(value1);
			}
		});
		return entries;		
	}
	
	public static void main(String[] args){
		Map p = new HashMap();
		p.put("C3.", 3);
		p.put("K1.", 1);
		p.put("E2.", 2);
		p.put("P5.", 5);
		p.put("D4.", 4);
		
		Map.Entry[] set = getSortedMapByKey(p,SortUtil.SORTTYPE_DESC);
		for(int i=0;i<set.length;i++){
			System.out.print(set[i].getKey().toString());
			System.out.println(set[i].getValue().toString());
		} 

		set = getSortedMapByValue(p,SortUtil.SORTTYPE_DESC);
		for(int i=0;i<set.length;i++){
			System.out.print(set[i].getKey().toString());
			System.out.println(set[i].getValue().toString());
		}
	}
	
	
	
}