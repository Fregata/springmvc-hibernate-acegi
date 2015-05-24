/*
 * @(#)BaseCdEntity.java
 *       
 * 功能描述：基于CD的持久对象的基类
 * 公用方法描述：
 * 
 * 修改人：
 * 修改日期：
 * 修改原因：
 * 
 * 
 */
package com.framework.entity;

public class BaseCdEntity implements java.io.Serializable { 

	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || !(o instanceof BaseCdEntity)) {
			return false;
		}
		BaseCdEntity other = (BaseCdEntity) o;
		
		// if the id is missing, return false
		if (getCode() == null) return false;
		
		// equivalence by id
		return getCode().equals(other.getCode());
	}

	public int hashCode() {
		if (getCode() != null) {
			return getCode().hashCode();
		} else {
			return super.hashCode();
		}
	}

	public String toString() {
		return this.getClass().getName() + "[code=" + getCode() + "]";
	}
	
	 
	public String getCode() {
		return "1";
	} 
}
