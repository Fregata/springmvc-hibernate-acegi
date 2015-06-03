/**
 * 
 */
package com.business.web.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.persistence.vo.Geograph;
import com.business.util.CacheUtil;
import com.business.web.vo.City;
import com.business.web.vo.District;
import com.business.web.vo.ProfileInfo;
import com.business.web.vo.Province;

@Controller
public class ProfileController extends BaseController{

	
	@RequestMapping(value="/super/create-profile.html",method=RequestMethod.GET)
	public String createProfile(HttpServletRequest request,HttpServletResponse response){
		List<Province> pList = new ArrayList<Province>();
		Iterator<Entry> it=CacheUtil.getCache(CacheUtil.GEOGRAPH_CACHE).entrySet().iterator();
		while(it.hasNext()){
			Province p = (Province)it.next().getValue();
			pList.add(p);
		}
		request.getSession().setAttribute("PROVINCE", pList);
		return "create_profile_step1";
	}
	
	@RequestMapping(value="/super/city/{id}",method=RequestMethod.GET)
	@ResponseBody List<City> getCities(@PathVariable String id,HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");  
	    response.setContentType("application/json; charset=utf-8"); 
		List rsList = null;
		Iterator<Entry> it=CacheUtil.getCache(CacheUtil.GEOGRAPH_CACHE).entrySet().iterator();
		while(it.hasNext()){
			Province p = (Province)it.next().getValue();
			if(id.equals(p.getCode())){
				rsList = p.getCityList();
				break;
			}
		}
		return rsList;
	}
	
	@RequestMapping(value="/super/district/{id}",method=RequestMethod.GET)
	@ResponseBody List<District> getDistricts(@PathVariable String id) {
		List rsList = null;
		Iterator<Entry> it=CacheUtil.getCache(CacheUtil.GEOGRAPH_CACHE).entrySet().iterator();
		while(it.hasNext()){
			Province p = (Province)it.next().getValue();
			for(City c:p.getCityList()){
				if(id.equals(c.getCode())){
					rsList = c.getDictList();
					break;
				}
			}
		}
		return rsList;
	}
	
	@RequestMapping(value="/super/profile/step1.html",method=RequestMethod.POST)
	public String profileStep1(HttpServletRequest request,HttpServletResponse response){
		String sclName = request.getParameter("profile_name");
		//String province = request.getParameter("province");
		String city = request.getParameter("city");
		String district = request.getParameter("district");
		
		int sequence = (int)(Math.random() * 10000);
		ProfileInfo pi = new ProfileInfo(sclName,Integer.toString(sequence));
		
		if(district!=null&&district.startsWith(city.substring(0, 2))){
			pi.setGeograph((Geograph)CacheUtil.getCache(CacheUtil.DISTRICT_CACHE).get(district));
		}else{
			pi.setGeograph((Geograph)CacheUtil.getCache(CacheUtil.CITY_CACHE).get(city));
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("profileInfo", pi);
		session.setAttribute("gradeList", pi.getGradeInfoList());
		
		return "create_profile_step2";
	}
	
	@RequestMapping(value="/super/profile/step2.html",method=RequestMethod.POST)
	public String profileStep2(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		ProfileInfo pi = (ProfileInfo)session.getAttribute("profileInfo");
		session.setAttribute("clazzList", pi.getClazzInfoList());
		return "create_profile_step3";
	}
	
	@RequestMapping(value="/super/profile/step3.html",method=RequestMethod.POST)
	public String profileStep3(HttpServletRequest request,HttpServletResponse response){
		
		return "create_profile_confirm";
	}
	
	@RequestMapping(value="/super/create-subject.html",method=RequestMethod.GET)
	public String createSubject(){
		return "create_subject";
	}
	
	@RequestMapping(value="/super/import-teacher.html",method=RequestMethod.GET)
	public String importTeacher(){
		return "import_teacher";
	}
	
	@RequestMapping(value="/super/import-student.html",method=RequestMethod.GET)
	public String importStudent(){
		return "import_student";
	}
	
	
	
	
}
