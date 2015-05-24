/*
 * @(#)CriteriaCommand.java
 *       
 * 
 * 功能描述：Creates a command to wrap the Hibernate criteria API.
 * 公用方法描述：
 * 
 * 修改人：
 * 修改日期：
 * 修改原因：
 * 
 * 
 */ 
package com.framework.dao.util;

import org.hibernate.Criteria;

public interface CriteriaCommand {
	public Criteria execute(Criteria criteria);
}
