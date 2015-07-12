/**
 * 
 */
package com.business.web.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.business.persistence.vo.School;
import com.business.persistence.vo.SchoolRoll;
import com.business.persistence.vo.Subject;
import com.business.service.IPersisteManager;
import com.business.util.ExcelUtil;
import com.business.web.vo.ClazzVO;
import com.business.web.vo.GradeVO;
import com.business.web.vo.SubjectVO;
import com.business.web.vo.TeacherExcelVO;
import com.framework.service.IBaseService;

@Controller
public class TeacherController extends BaseController implements ServletContextAware{

	@Autowired
	IPersisteManager persisteManger;
	private IBaseService iBaseService = null;
	private ServletContext servletContext;
	
	@RequestMapping(value="/super/teacher/step1.html",method=RequestMethod.GET)
	public String teacherStep1(HttpServletRequest request,HttpServletResponse response){
		List<School> sclList = this.getBaseService().loadAll(School.class);
		request.getSession().setAttribute("SCHOOLS", sclList);
		return "import_teacher_step1";
	}
	
	@RequestMapping(value="/super/teacher/{id}",method=RequestMethod.GET)
	public void fileDownLoad(@PathVariable String id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		//file name and root path
		String fileName = "teacher-data.xls";
        //String path = servletContext.getRealPath("/");
        
        //create workbook
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
        	List<GradeVO> grdList = new ArrayList<GradeVO>();
        	List<SchoolRoll> srList = getBaseService().findByLike(SchoolRoll.class, "parentId", id, "id");
    		for(SchoolRoll sr:srList){
    			GradeVO grd = new GradeVO(sr.getName(),String.valueOf(sr.getId()));
    			List<SchoolRoll> clzList = getBaseService().findByLike(SchoolRoll.class, "parentId", String.valueOf(sr.getId()), "id");
    			for(SchoolRoll clz:clzList){
    				ClazzVO cv = new ClazzVO(String.valueOf(clz.getId()),clz.getCode(),clz.getName());
    				for(Subject s:clz.getSubjects()){
    					cv.getSubList().add(new SubjectVO(s.getName(),s.getCode()));
    				}
    				grd.getClzList().add(cv);
    			}
    			grdList.add(grd);
    		}
        	ExcelUtil.createTeacherTemplate(grdList).write(os);
        } catch (IOException e) {
        	e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        
        //setup response configuration
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(fileName.getBytes(), "iso-8859-1"));
        
        //write to response output stream
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
        	bis = new BufferedInputStream(is);
        	bos = new BufferedOutputStream(out);
        	byte[] buff = new byte[2048];
        	int bytesRead;
        	// Simple read/write loop.
        	while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
        		bos.write(buff, 0, bytesRead);
        	}
        } catch (final IOException e) {
        	e.printStackTrace();
        } finally {
        	if (bis != null)
        		bis.close();
        	if (bos != null)
        		bos.close();
        }
	}
	
	@RequestMapping(value="/super/teacher/step2.html",method=RequestMethod.POST)
	public String teacherStep2(DefaultMultipartHttpServletRequest request){
		
		String rtUrl = "import_teacher_step2";
		String savePath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
		String tempPath = request.getSession().getServletContext().getRealPath("/WEB-INF/temp");
		List<TeacherExcelVO> teList = null;
		
		File tmpFile = new File(tempPath);
		if (!tmpFile.exists()) {
			tmpFile.mkdir();
		}
		
		try{
			//使用Apache文件上传组件处理文件上传步骤：
			//1、创建一个DiskFileItemFactory工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中。
			factory.setSizeThreshold(1024*100);//设置缓冲区的大小为100KB，如果不指定，那么缓冲区的大小默认是10KB
			//设置上传时生成的临时文件的保存目录
			factory.setRepository(tmpFile);
			//2、创建一个文件上传解析器
			ServletFileUpload upload = new ServletFileUpload(factory);
			//监听文件上传进度
			upload.setProgressListener(new ProgressListener(){
				public void update(long pBytesRead, long pContentLength, int arg2) {
					System.out.println("文件大小为：" + pContentLength + ",当前已处理：" + pBytesRead);
				}
			});
			 //解决上传文件名的中文乱码
			upload.setHeaderEncoding("UTF-8");
			//3、判断提交上来的数据是否是上传表单的数据
			if(!ServletFileUpload.isMultipartContent(request)){
				rtUrl= "import_teacher_step1";
			}
			
			//设置上传单个文件的大小的最大值，目前是设置为1024*1024字节，也就是1MB
			upload.setFileSizeMax(1024*1024);
			//设置上传文件总量的最大值，最大值=同时上传的多个文件的大小的最大值的和，目前设置为10MB
			upload.setSizeMax(1024*1024*10);
			//4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
			Map<String,List<MultipartFile>> map = request.getMultiFileMap();
			
			for(Entry e: map.entrySet()){
				List<CommonsMultipartFile> fList = (List<CommonsMultipartFile>) e.getValue();
				CommonsMultipartFile f = fList.get(0);
				if(doSave(f.getFileItem(),savePath)){
					String fileName = f.getFileItem().getName();
					fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
					savePath = savePath.concat("\\"+fileName);
					teList = ExcelUtil.readTeacherFile(savePath);
				}else{
					rtUrl= "import_teacher_step1";
				}
			}
		}catch(Exception e) {
			rtUrl= "import_teacher_step1";
		}
		request.getSession().setAttribute("TEACHERDATA", teList);
		return rtUrl;
	}
	
	@RequestMapping(value="/super/teacher/data",method=RequestMethod.GET)
	@ResponseBody List<TeacherExcelVO> getData(HttpServletRequest request){
		List<TeacherExcelVO> teData = (List<TeacherExcelVO>)request.getSession().getAttribute("TEACHERDATA");
		verifyData(teData);
		return teData;
	}
	
	@RequestMapping(value="/super/teacher/data/update",method=RequestMethod.POST)
	@ResponseBody String updateData(HttpServletRequest request) throws Exception{
		List<TeacherExcelVO> teData = (List<TeacherExcelVO>)request.getSession().getAttribute("TEACHERDATA");
		int index = Integer.valueOf(request.getParameter("index"));
		String field = request.getParameter("field");
		String value = request.getParameter("value");
		
		TeacherExcelVO te = teData.get(index);
		String methodName = "set"+field.substring(0, 1).toUpperCase()+field.substring(1);
		Method setMethod = te.getClass().getDeclaredMethod(methodName, String.class);
		setMethod.invoke(te, value);
		return "SUCCESS";
	}
	
	@RequestMapping(value="/super/teacher/step3.html",method=RequestMethod.POST)
	public String teacherStep3(HttpServletRequest request){
		String url = "import_teacher_step3";
		List<TeacherExcelVO> teData = (List<TeacherExcelVO>)request.getSession().getAttribute("TEACHERDATA");
		if(!verifyData(teData)){
			url = "import_teacher_step2";
			request.getSession().setAttribute("ERROR", "数据校验失败,请双击表格数据修改数据!");
		}else{
			request.getSession().removeAttribute("ERROR");
		}
		return url;
	}
	
	@RequestMapping(value="/super/teacher/step4.html",method=RequestMethod.POST)
	public String teacherStep4(HttpServletRequest request){
		String url = "import_teacher_step3";
		List<TeacherExcelVO> teData = (List<TeacherExcelVO>)request.getSession().getAttribute("TEACHERDATA");
		if(persisteManger.saveTeacherInfo(teData)){
			url = "import_teacher_step1";
			request.getSession().removeAttribute("ERROR");
		}else{
			request.getSession().setAttribute("ERROR", "教师数据保存失败!");
		}
		
		return url;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public IBaseService getiBaseService() {
		if(iBaseService==null){
			iBaseService = (IBaseService)persisteManger.getStaticBean("IBaseService");
		}
		return iBaseService;
	}
	
	private boolean doSave(FileItem item,String savePath) throws Exception{
		boolean rs  = true;
		if(item.isFormField()){
			rs = false;
		}else{
			//如果fileitem中封装的是上传文件
			//得到上传的文件名称，
			String filename = item.getName();
			if(filename==null || filename.trim().equals("")){
				rs = false;
			}
			//注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
			//处理获取到的上传文件的文件名的路径部分，只保留文件名部分
			filename = filename.substring(filename.lastIndexOf("\\")+1);
			//得到上传文件的扩展名
			String fileExtName = filename.substring(filename.lastIndexOf(".")+1);
			//获取item中的上传文件的输入流
			InputStream input = item.getInputStream();
			//得到文件保存的名称
			//String saveFilename = makeFileName(filename);
			//得到文件的保存目录
			String realSavePath = makePath(savePath);
			//创建一个文件输出流
			FileOutputStream out = new FileOutputStream(realSavePath + "\\" + filename);
			//创建一个缓冲区
			byte[] buffer = new byte[1024];
			//判断输入流中的数据是否已经读完的标识
			int len = 0;
			//循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
			while((len=input.read(buffer))>0){
				//使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
				out.write(buffer, 0, len);
			}
			//关闭输入流
			input.close();
			//关闭输出流
			out.close();
		}
		return rs;
	}
	private String makePath(String savePath){
//		 //得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
//		 int hashcode = filename.hashCode();
//		 int dir1 = hashcode&0xf;  //0--15
//		 int dir2 = (hashcode&0xf0)>>4;  //0-15
//		 //构造新的保存目录
//		 String dir = savePath + "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
		 //File既可以代表文件也可以代表目录
		 File file = new File(savePath);
		 //如果目录不存在
		 if(!file.exists()){
			 //创建目录
			 file.mkdirs();
		 }
		 return savePath;
	 }
	
	private boolean verifyData(List<TeacherExcelVO> teData){
		boolean isSuccess = true;
		//verify data
		for(TeacherExcelVO t:teData){
			//1. verify class whether exist or not
			SchoolRoll clz = getBaseService().load(SchoolRoll.class, Integer.valueOf(t.getClassID()));
			if(clz == null){
				t.setIsValid("No");
				isSuccess = false;
				continue;
			}
			//2. verify subject whether exist or not
			List<String> codes = getBaseService().find("select s.code from Subject as s where s.schoolRoll.id="+String.valueOf(clz.getId()));
			if(!codes.contains(t.getSubjectID())){
				t.setIsValid("No");
				isSuccess = false;
				continue;
			}
			//3. verify teacher code format
			if("".equals(t.getTeaCode())||t.getTeaCode().length()>10){
				t.setIsValid("No");
				isSuccess = false;
				continue;
			}
			//4. verify teacher name
			if("".equals(t.getTeaName())||t.getTeaName().length()>30){
				t.setIsValid("No");
				isSuccess = false;
				continue;
			}
			//5. verify teacher gender
			//6. verify teacher age
			//7. verify teacher phone
			//8. verify teacher Email address
			t.setIsValid("Yes");
		}
		return isSuccess;
	}
}
