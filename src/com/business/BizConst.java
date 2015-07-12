package com.business;

import java.util.HashMap;
import java.util.Map;

public class BizConst {

	public static final String GRADEID = "grdId-";
	public static final String SUBJECTID = "subjects-";
	public static final Map<String, String> SUBJECTMAP = new HashMap<String,String>(){
		{
			put("SUB001","语文");
			put("SUB002","数学");
			put("SUB003","英语");
			put("SUB004","化学");
			put("SUB005","物理");
			put("SUB006","生物");
			put("SUB007","地理");
			put("SUB008","历史");
			put("SUB009","政治");
		}
	};
}
