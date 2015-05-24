/*
 * @(#)PropertyComparator.java
 *       
 * 功能描述： 缺省为升序排列，也可以指定为降序排列 
 *   对于属性为字符串或者属性本身为数值型可用
 *   如果属性为字符串，想把他做为数值型来比较，那么这里不可用 
 *   sortType == ASC 升序－－缺省的排列方式
 *   sortType == DES 降序－－
 *   
 * 公用方法描述：
 * 
 * 修改人：
 * 修改日期：
 * 修改原因：
 * 
 * 
 */

package com.framework.util.comparator;

import java.util.Comparator;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.comparators.ComparableComparator;

import com.framework.exception.BaseSysException;
 
public class PropertyComparator implements Comparator{  
	private String attribute = null;  
	private String sortType = "ASC";
	
    private Comparator comp = new ComparableComparator();  
    public PropertyComparator(String attrib) { 
        this.attribute = attrib; 
    } 
    public PropertyComparator(String attrib,String sortType) { 
        this.attribute = attrib; 
        this.sortType = sortType;
    } 

    public int compare(Object o1, Object o2) throws BaseSysException{    	
        if(o1 == null)  return 1; 
        if(o2 == null)  return -1; 

        try { 
            Object ret1 = PropertyUtils.getProperty(o1, this.attribute); 
            Object ret2 = PropertyUtils.getProperty(o2, this.attribute); 
            if("DSC".equals(sortType))
            	return this.comp.compare(ret2, ret1);            
            return this.comp.compare(ret1, ret2);
        } catch(Exception e) {
        	throw new BaseSysException(e); 
        } 
    }  
}
