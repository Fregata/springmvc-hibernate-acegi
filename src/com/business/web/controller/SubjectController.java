/**
 * 
 */
package com.business.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.BizConst;
import com.business.persistence.vo.School;
import com.business.persistence.vo.SchoolRoll;
import com.business.service.IPersisteManager;
import com.business.web.vo.GradeVO;
import com.business.web.vo.SubjectVO;
import com.framework.service.IBaseService;

@Controller
public class SubjectController extends BaseController{

	@Autowired
	private IPersisteManager persisteManger;
	private IBaseService iBaseService = null;
	
	@RequestMapping(value="/super/subject/step1.html",method=RequestMethod.GET)
	public String subjectStep1(HttpServletRequest request,HttpServletResponse response){
		iBaseService = (IBaseService)persisteManger.getStaticBean("IBaseService");
		List<School> sclList = iBaseService.loadAll(School.class);
		request.getSession().setAttribute("SCHOOLS", sclList);
		return "create_subject_step1";
	}
	
	@RequestMapping(value="/super/subject/{id}",method=RequestMethod.GET)
	@ResponseBody List<GradeVO> getGrades(@PathVariable String id,HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");  
	    response.setContentType("application/json; charset=utf-8"); 
	    
	    List<GradeVO> grdList = new ArrayList<GradeVO>(12);
	    List<SchoolRoll> srList = iBaseService.findByLike(SchoolRoll.class, "parentId", id, "id");
		for(SchoolRoll sr:srList){
			grdList.add(new GradeVO(sr.getName(),String.valueOf(sr.getId())));
		}
		return grdList;
	}
	
	@RequestMapping(value="/super/subject/step2.html",method=RequestMethod.POST)
	public String subjectStep2(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		String schoolId = request.getParameter("school");
		String grdJson = request.getParameter("grdJson");
		
		School schoolObj = null;
		List<GradeVO> gradeList = generateGradeVO(grdJson.split(":"));
		List<School> sclList = (List<School>)request.getSession().getAttribute("SCHOOLS");
		for(School s:sclList){
			if(schoolId.equals(String.valueOf(s.getSchoolRoll().getId()))){
				schoolObj = s;
				break;
			}
		}
		
		request.getSession().setAttribute("GRADES", gradeList);
		request.getSession().setAttribute("CHECKEDSCHOOL", schoolObj);
		
		return "create_subject_step2";
	}
	
	@RequestMapping(value="/super/subject/step3.html",method=RequestMethod.POST)
	public String subjectStep3(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		
		String grdId = null;
		String subjects = null;
		List<GradeVO> gradeList = (List<GradeVO>)request.getSession().getAttribute("GRADES");
		for(int i=1;i<=12;i++){
			grdId = request.getParameter(BizConst.GRADEID+i);
			subjects = request.getParameter(BizConst.SUBJECTID+i);
			if(grdId==null || subjects==null) break;
			addSujects(gradeList,grdId,subjects);
		}
		request.getSession().setAttribute("ERROR", null);
		request.getSession().setAttribute("GRADES", gradeList);
		return "create_subject_step3";
	}
	


	@RequestMapping(value="/super/subject/step4.html",method=RequestMethod.POST)
	public String subjectStep4(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String url = null;
		String errorMsg = null;
		
		School school = (School)request.getSession().getAttribute("CHECKEDSCHOOL");
		List<GradeVO> gradeList = (List<GradeVO>)request.getSession().getAttribute("GRADES");
		
		boolean isSuccess = persisteManger.saveSubjectInfo(school,gradeList);
		if(isSuccess){
			url = "create_subject_step1";
		}else{
			url = "create_subject_step3";
			errorMsg = "保存科目信息失败!";
		}
		request.getSession().setAttribute("ERROR", errorMsg);
		return url;
	}
	

	private void addSujects(List<GradeVO> gradeList, String grdId, String subjects) {
		String[] split = subjects.split("-");
		List<SubjectVO> subList = new ArrayList<SubjectVO>();
		for(String str:split){
			subList.add(new SubjectVO(BizConst.SUBJECTMAP.get(str),str));
		}
		
		for(GradeVO g:gradeList){
			if(grdId.equals(g.getCode())){
				g.setSubList(subList);
				break;
			}
		}
	}

	private List<GradeVO> generateGradeVO(String[] split) {
		List<GradeVO> list = new ArrayList<GradeVO>();
		for(String str:split){
			list.add(new GradeVO(str.split("-")[0],str.split("-")[1]));
		}
		return list;
	}
	
	
}
