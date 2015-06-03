package com.business.web.controller;

import org.springframework.stereotype.Controller;

import com.framework.service.BaseService;
import com.framework.service.IBaseService;

@Controller
public class BaseController {

	
	private IBaseService baseService;
	
	public IBaseService getBaseService(){
		return (IBaseService)BaseService.getBeanStatic("IBaseService");
	}
}
