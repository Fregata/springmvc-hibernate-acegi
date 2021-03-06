/**
 * 
 */
package com.business.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NavigateController extends BaseController{

	@RequestMapping(value="/user/logon.html",method=RequestMethod.POST)
	public String sigin(String userName,String passWord){
		return "main";
	}
	
	@RequestMapping(value="/user/main.html",method=RequestMethod.GET)
	public String main(){
		return "main";
	}
	
	@RequestMapping(value="/user/info.html",method=RequestMethod.GET)
	public String info(){
		return "info_fnd";
	}
	
	@RequestMapping(value="/user/logout.html",method=RequestMethod.GET)
	public String logout(){
		return "login";
	}
	
	@RequestMapping(value="/super/input.html",method=RequestMethod.GET)
	public String input(){
		return "info_int";
	}
	
	@RequestMapping(value="/super/data.html",method=RequestMethod.GET)
	public String data(){
		return "data_imp";
	}
	
	@RequestMapping(value="/admin/system.html",method=RequestMethod.GET)
	public String system(){
		return "system";
	}
	
	@RequestMapping(value="/admin/setting.html",method=RequestMethod.GET)
	public String setting(){
		return "setting";
	}
	
	
	
}
