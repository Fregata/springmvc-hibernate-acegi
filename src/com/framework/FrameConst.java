/*
 * @(#)FrameConst.java
 *       
 * 系统名称：东航电子商务国内B2C系统
 * 版本号：1.0
 * 
 * Copyright (c)  TravelSky
 * All Rights Reserved.
 * 
 * 作者：hujq
 * 创建日期：May 6, 2010
 * 
 * 功能描述：
 * 公用方法描述：
 * 
 * 修改人：
 * 修改日期：
 * 修改原因：
 * 
 * 
 */

package com.framework; 

public class FrameConst
{
	  public static final String DICT_TYPE_VALIDATE = "DICT_TYPE_VALIDATE";
	    public static final long STATUS_INVALIDATE  = 0;               //无效  
	    public static final long STATUS_VALIDATE    = 1;	           //有效
	    //是、否
	    public static final String DICT_TYPE_YESNO = "DICT_TYPE_YESNO";
	    public static final long YES      = 7;	                      //是
	    public static final long NO       = 8;	                      //否

		//后台表格中，每页的记录数目
		public static int     TABLE_PAGE_LENGTH  = 10;
		
		//E3 Table
		public static final String TATAL_SIZE        = "DM_TOTAL_SIZE";
		public static final String TABLE_DATA        = "tabledata"; 
		public static final String TABLE_IN_JSP      = "tableInJsp";
		public static final String TABLE_LIMIT       = "tablelimit";  
		public static final String JMESA_BASE_COND   = "JMESA_BASE_COND";  
}
