/*
 * @(#)BaseNoEntity.java
 *       
 * 功能描述：基础的Entity对象，重写equals和hashcode方法用于对象之间的比较
 * 公用方法描述：
 * 
 * 修改人：
 * 修改日期：
 * 修改原因：
 * 
 * 
 */
package com.framework.entity;

import java.util.Date;
 
public class BaseNoEntity implements java.io.Serializable {

	private String serialNo;
	
	private Long   version;
	private String optId;
	private Date optDt;
	private Long   delFlag; 

	public boolean equals(Object o) {
		if (this == o) return true;
		
		if (o == null || !(o instanceof BaseNoEntity)) {
			return false;
		}
		BaseNoEntity other = (BaseNoEntity) o;
		
		// if the id is missing, return false
		if (serialNo == null) return false;
		
		// equivalence by id
		return serialNo.equals(other.getSerialNo());
	}

	public int hashCode() {
		if (serialNo != null) {
			return serialNo.hashCode();
		} else {
			return super.hashCode();
		}
	}

	public String toString() {
		return this.getClass().getName() + "[SerialNo=" + serialNo + "]";
	}
	
	  
	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public String getOptId() {
		return optId;
	}
	public void setOptId(String optId) {
		this.optId = optId;
	}
	public Date getOptDt() {
		return optDt;
	}
	public void setOptDt(Date optDt) {
		this.optDt = optDt;
	}
	public Long getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Long delFlag) {
		this.delFlag = delFlag;
	}
}
