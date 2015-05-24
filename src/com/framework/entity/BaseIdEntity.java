/*
 * @(#)BaseIdEntity.java
 *       
 * 功能描述：基于ID的持久对象的基类
 * 公用方法描述：
 * 
 * 修改人：
 * 修改日期：
 * 修改原因：
 * 
 * 
 */
package com.framework.entity;
 
public class BaseIdEntity{

	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || !(o instanceof BaseIdEntity)) {
			return false;
		}
		BaseIdEntity other = (BaseIdEntity) o;
		
		// if the id is missing, return false
		if (getId() == null) return false;
		
		// equivalence by id
		return getId().equals(other.getId());
	}

	public int hashCode() {
		if (getId() != null) {
			return getId().hashCode();
		} else {
			return super.hashCode();
		}
	}

	public String toString() {
		return this.getClass().getName() + "[id=" + getId() + "]";
	} 
	
	public Long getId() {
		return 1L;
	} 
}
