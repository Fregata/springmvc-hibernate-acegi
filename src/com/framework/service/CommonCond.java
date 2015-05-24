/*
 * @(#)CommonCond.java
 *       
 * 功能描述：无需更改查询条件的查询，直接把HQL作为参数传入即可
 * 公用方法描述：
 * 
 * 修改人：
 * 修改日期：
 * 修改原因：
 * 
 * 
 */
package com.framework.service;
 
public class CommonCond extends BaseCond{ 
	private String hql;
 
	public CommonCond(String hql){
		this.hql = hql;
	}
	
	public String getHQL() {
		return hql;
	}
}
