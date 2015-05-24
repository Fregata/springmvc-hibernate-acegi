/*
 * @(#)BaseCond.java
 *       
 E
 * 功能描述：查询条件基类
 * 公用方法描述：
 * 
 * 修改人：
 * 修改日期：
 * 修改原因：
 * 
 * 
 */
package com.framework.service;

import org.springframework.util.Assert;

import com.framework.FrameConst;
import com.framework.dao.DaoUtil;

public abstract class BaseCond {    
    private String sortString;    
    private int start;    
    private int page;    
    private int pageSize = FrameConst.TABLE_PAGE_LENGTH;
	public  abstract String getHQL();
	public   void setFlagCrteria(StringBuffer hql,String voInfo){
		DaoUtil.append(hql, voInfo+".delFlag =" + FrameConst.STATUS_VALIDATE);
	}
	private boolean needCount = true; 
	 
	/////////////////////////////////////////////////////////////////////////////////
    //-----------------------------  ?  -----------------------------------//
	/////////////////////////////////////////////////////////////////////////////////	
    
	public String createQueryString()
    {
        String hql = this.getHQL();
		Assert.isTrue(hql != null, " hql : " + hql + " must cannot be null !");

		if (sortString != null && !"".equals(sortString) ){
            hql = DaoUtil.removeOrders(hql) + this.getSortString();        
        }
        
        return hql.toString(); 
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////
	public int getPageSize() {
		return this.pageSize == 0 ? FrameConst.TABLE_PAGE_LENGTH : this.pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
		this.start = page < 1 ? 0:(page -1)*pageSize;
	} 
	public boolean isNeedCount() {
		return needCount;
	} 
	public void setNeedCount(boolean needCount) {
		this.needCount = needCount;
	}

	public String getSortString() {
		return sortString;
	}

	public void setSortString(String sortString) {
		this.sortString = sortString;
	}
	
	///////////////////////////////////////////////
	//                                           //
	///////////////////////////////////////////////
	public int queryType;
	public int getQueryType() {
		return queryType;
	}
	public void setQueryType(int queryType) {
		this.queryType = queryType;
	}
}
