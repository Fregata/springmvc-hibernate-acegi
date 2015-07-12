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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.persistence.vo.Geograph;
import com.business.service.IPersisteManager;
import com.business.util.CacheUtil;
import com.business.web.vo.City;
import com.business.web.vo.ClazzVO;
import com.business.web.vo.District;
import com.business.web.vo.GradeVO;
import com.business.web.vo.ProfileInfo;
import com.business.web.vo.Province;

@Controller
public class ProfileController extends BaseController{

	@Autowired
	IPersisteManager persisteManger;
	
	@RequestMapping(value="/super/profile/step1.html",method=RequestMethod.GET)
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
	
	@RequestMapping(value="/super/profile/step2.html",method=RequestMethod.POST)
	public String profileStep1(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		String sclName = request.getParameter("profile_name");
		String sclCode = request.getParameter("profile_code");
		String sclType = request.getParameter("profile_type");
		String sclAttr = request.getParameter("profile_attr");
		String sclLevel = request.getParameter("profile_level");
		String sclAddr = request.getParameter("profile_address");
		//String province = request.getParameter("province");
		String city = request.getParameter("city");
		String district = request.getParameter("district");
		String grdJson = request.getParameter("grdJson");
		String clzJson = request.getParameter("clzJson");
		
		List<GradeVO> gradeList = generateGradeVO(grdJson.split(":"));
		List<ClazzVO> clazzList = generateClazzVO(clzJson.split(":"));
		
		for(GradeVO grdVO:gradeList){
			String code = grdVO.getCode();
			for(ClazzVO clzVO:clazzList){
				if(clzVO.getCode().startsWith(code.substring(0, 2))){
					grdVO.getClzList().add(clzVO);
				}
			}
		}
		
		Geograph geo = null;
		if(district!=null&&district.startsWith(city.substring(0, 2))){
			geo = (Geograph)CacheUtil.getCache(CacheUtil.DISTRICT_CACHE).get(district);
		}else{
			geo = (Geograph)CacheUtil.getCache(CacheUtil.CITY_CACHE).get(city);
		}
		
		//int sequence = (int)(Math.random() * 10000);
		ProfileInfo pi = new ProfileInfo(sclName,sclCode,sclType,sclAttr,sclLevel,sclAddr,gradeList);
		pi.setGeograph(geo);
		
		HttpSession session = request.getSession();
		session.setAttribute("profileInfo", pi);
		session.setAttribute("schoolroll", pi.getScl_SchoolRoll());
		session.setAttribute("geograph", pi.getGeograph());
		session.setAttribute("gradeList", gradeList);
		session.setAttribute("ERROR", null);
		
		return "create_profile_step2";
	}
	
	@RequestMapping(value="/super/profile/step3.html",method=RequestMethod.POST)
	public String profileStep2(HttpServletRequest request,HttpServletResponse response){
		String url = null;
		String errorMsg = null;
		
		HttpSession session = request.getSession();
		ProfileInfo pi = (ProfileInfo)session.getAttribute("profileInfo");
		boolean isSuccess = persisteManger.saveProfileInfo(pi);
		if(isSuccess){
			url = "create_profile_step1";
		}else{
			url = "create_profile_step2";
			errorMsg = "保存学校基础信息失败!";
		}
		session.setAttribute("ERROR", errorMsg);
		return url;
	}
	
	@RequestMapping(value="/super/import-teacher.html",method=RequestMethod.GET)
	public String importTeacher(){
		return "import_teacher";
	}
	
	@RequestMapping(value="/super/import-student.html",method=RequestMethod.GET)
	public String importStudent(){
		return "import_student";
	}
	
	private List<GradeVO> generateGradeVO(String[] split) {
		List<GradeVO> list = new ArrayList<GradeVO>();
		for(String str:split){
			list.add(new GradeVO(str.split("-")[0],str.split("-")[1]));
		}
		return list;
	}

	private List<ClazzVO> generateClazzVO(String[] split) {
		List<ClazzVO> list = new ArrayList<ClazzVO>();
		for(String str:split){
			list.add(new ClazzVO(str.split("-")[0],str.split("-")[1]));
		}
		return list;
	}
}
