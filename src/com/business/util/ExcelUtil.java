package com.business.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.business.web.vo.ClazzVO;
import com.business.web.vo.GradeVO;
import com.business.web.vo.StudentExcelVO;
import com.business.web.vo.SubjectVO;
import com.business.web.vo.TeacherExcelVO;

public class ExcelUtil {

	public static HSSFWorkbook createTeacherTemplate(List<GradeVO> grdList){
		/*
		 * 身份证、民族、生日、籍贯、毕业学校（选择下拉框）、专业、教师学历、教师状态、是否有上岗证、岗位性质、职称、职务、任教起始日期、入校日期、离校日期、家庭住址、邮编、固定电话、手机、即时通讯号、备注
		 */
		Map<Integer,String[]> headerMap = new HashMap<Integer,String[]>(){
			{
				put(0,new String[]{"5000","班级ID"});
				put(1,new String[]{"5000","班级代码"});
				put(2,new String[]{"10000","班级名称"});
				put(3,new String[]{"5000","课程代码"});
				put(4,new String[]{"5000","课程名称"});
				put(5,new String[]{"5000","教师代码"});
				put(6,new String[]{"5000","教师姓名"});
				put(7,new String[]{"2000","性别  "});
				put(8,new String[]{"5000","生日"});
				put(9,new String[]{"5000","电话号码"});
				put(10,new String[]{"5000","邮箱地址"});
				put(11,new String[]{"5000","开始时间"});
				put(12,new String[]{"5000","结束时间"});
				put(13,new String[]{"5000","身份证"});
				put(14,new String[]{"5000","民族"});
				put(15,new String[]{"5000","籍贯"});
				put(16,new String[]{"5000","毕业学校"});
				put(17,new String[]{"5000","专业"});
				put(18,new String[]{"5000","教师学历"});
				put(19,new String[]{"5000","教师状态"});
				put(20,new String[]{"5000","是否有上岗证"});
				put(21,new String[]{"5000","岗位性质"});
				put(22,new String[]{"5000","职称"});
				put(23,new String[]{"5000","职务"});
				put(24,new String[]{"5000","入校日期"});
				put(25,new String[]{"5000","离校日期"});
				put(26,new String[]{"5000","家庭住址"});
				put(27,new String[]{"5000","邮编"});
				put(28,new String[]{"5000","固定电话"});
				put(29,new String[]{"5000","即时通讯号"});
				put(30,new String[]{"5000","备注"});
			}
		};
	    
		HSSFWorkbook wb = new HSSFWorkbook();
	    createHeader(wb,headerMap);
	    
	    HSSFCellStyle style = wb.createCellStyle();
	    HSSFFont font = wb.createFont();
	    font.setFontName("Verdana");
	    font.setBoldweight((short) 50);
	    font.setFontHeight((short) 150);
	    style.setFont(font);
	    
	    HSSFSheet sheet = wb.getSheetAt(0);
	    int index = 1;
	    for(int i=0;i<grdList.size();i++){
	    	GradeVO grade = grdList.get(i);
	    	List<ClazzVO> clzList = grade.getClzList();
	    	for(int j=0;j<clzList.size();j++){
	    		ClazzVO clazz = clzList.get(j);
	    		List<SubjectVO> subList = clazz.getSubList();
	    		for(int k=0;k<subList.size();k++){
	    			SubjectVO subject = subList.get(k);
	    			HSSFRow row = sheet.createRow(index);
	    			
	    			HSSFCell cell0 = row.createCell(0);
	    	    	cell0.setCellValue(clazz.getId());
	    	    	cell0.setCellStyle(style);
	    	    	
	    			HSSFCell cell1 = row.createCell(1);
	    	    	cell1.setCellValue(clazz.getCode());
	    	    	cell1.setCellStyle(style);
	    	    	
	    	    	HSSFCell cell2 = row.createCell(2);
	    	    	cell2.setCellValue(clazz.getName());
	    	    	cell2.setCellStyle(style);
	    	    	
	    	    	HSSFCell cell3 = row.createCell(3);
	    	    	cell3.setCellValue(subject.getCode());
	    	 	    cell3.setCellStyle(style);
	    	 	    
	    	 	    HSSFCell cell4 = row.createCell(4);
	    	 	    cell4.setCellValue(subject.getName());
	    	 	    cell4.setCellStyle(style);
	    	 	    
	    			index++;
	    		}
	    	}
	    }
		return wb;
	}
	
	public static HSSFWorkbook createStudentTemplate(List<GradeVO> grdList) {
		/*
		 * 学籍号、学号、籍贯、身份证、出生日期、家庭住址、邮编、学生状态、家庭类型、知识等级、生源性质、学生职务、入校日期、离校日期、民族、血型、户籍地址、户籍邮编、固定电话、手机、即时通讯、备注
		 */
		Map<Integer,String[]> headerMap = new HashMap<Integer,String[]>(){
			{
				put(0, new String[]{"5000","班级ID"});
				put(1, new String[]{"5000","班级代码"});
			    put(2, new String[]{"10000","班级名称"});
			    put(3, new String[]{"5000","学生代码"});
			    put(4, new String[]{"5000","学生姓名"});
			    put(5, new String[]{"2000","性别   "});
			    put(6, new String[]{"2000","出生日期"});
			    put(7, new String[]{"5000","电话号码"});
			    put(8, new String[]{"5000","邮箱地址"});
			    put(9,new String[]{"5000","开始时间"});
				put(10,new String[]{"5000","结束时间"});
				put(11,new String[]{"5000","学籍号"});
				put(12,new String[]{"5000","籍贯"});
				put(13,new String[]{"5000","身份证"});
				put(14,new String[]{"5000","家庭住址"});
				put(15,new String[]{"5000","邮编"});
				put(16,new String[]{"5000","学生状态"});
				put(17,new String[]{"5000","家庭类型"});
				put(18,new String[]{"5000","知识等级"});
				put(19,new String[]{"5000","生源性质"});
				put(20,new String[]{"5000","学生职务"});
				put(21,new String[]{"5000","入校日期"});
				put(22,new String[]{"5000","离校日期"});
				put(23,new String[]{"5000","民族"});
				put(24,new String[]{"5000","血型"});
				put(25,new String[]{"5000","户籍地址"});
				put(26,new String[]{"5000","户籍邮编"});
				put(27,new String[]{"5000","固定电话"});
				put(28,new String[]{"5000","即时通讯"});
				put(29,new String[]{"5000","备注"});
			}
		};
		HSSFWorkbook wb = new HSSFWorkbook();
		createHeader(wb,headerMap);
	    
	    HSSFCellStyle style = wb.createCellStyle();
	    HSSFFont font = wb.createFont();
	    font.setFontName("Verdana");
	    font.setBoldweight((short) 50);
	    font.setFontHeight((short) 150);
	    style.setFont(font);
	    
	    HSSFSheet sheet = wb.getSheetAt(0);
	    int index = 1;
	    for(int i=0;i<grdList.size();i++){
	    	GradeVO grade = grdList.get(i);
	    	List<ClazzVO> clzList = grade.getClzList();
	    	for(int j=0;j<clzList.size();j++){
	    		ClazzVO clazz = clzList.get(j);
	    		HSSFRow row = sheet.createRow(index);
    			
	    		HSSFCell cell0 = row.createCell(0);
    	    	cell0.setCellValue(clazz.getId());
    	    	cell0.setCellStyle(style);
    	    	
    			HSSFCell cell1 = row.createCell(1);
    	    	cell1.setCellValue(clazz.getCode());
    	    	cell1.setCellStyle(style);
    	    	
    	    	HSSFCell cell2 = row.createCell(2);
    	    	cell2.setCellValue(clazz.getName());
    	    	cell2.setCellStyle(style);
    	    	
    			index++;
	    	}
	    }
		return wb;
	}
	
	private static void createHeader(HSSFWorkbook wb,Map<Integer,String[]> headerMap) {
		HSSFSheet sheet1 = wb.createSheet("数据信息");
		// 创建字体样式
		HSSFFont font = wb.createFont();
		font.setFontName("Verdana");
		font.setBoldweight((short) 50);
		font.setFontHeight((short) 150);
		font.setColor(HSSFColor.BLUE.index);
		// 创建单元格样式
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		style.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		// 设置边框
		style.setBottomBorderColor(HSSFColor.RED.index);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setFont(font);// 设置字体
		
		
	    // 设置excel每列宽度
		for(Entry e:headerMap.entrySet()){
			int index = (Integer)e.getKey();
			int width = Integer.valueOf(((String[])e.getValue())[0]);
			sheet1.setColumnWidth(index, width);
		}
	    
		HSSFRow row = sheet1.createRow(0);
		for(Entry e:headerMap.entrySet()){
			int index = (Integer)e.getKey();
			String value = ((String[])e.getValue())[1];
			HSSFCell cell = row.createCell(index);
		    cell.setCellStyle(style);
		    cell.setCellValue(value);
		}
	}
	
	public static List<TeacherExcelVO> readTeacherFile(String filePath){
		TeacherExcelVO te = null;
		List<TeacherExcelVO> teList = new ArrayList<TeacherExcelVO>();
		HSSFWorkbook wb = null;
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(filePath);
			wb = new HSSFWorkbook(inputStream);
			HSSFSheet sheet = wb.getSheetAt(0);
			
			for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
				HSSFCell[] cells = new HSSFCell[31];
				HSSFRow row = sheet.getRow(rowNum);
				if (row != null) {
					for(int i=0;i<cells.length;i++){
						cells[i] = row.getCell(i);
					}
					String[] values = getHSSFCellValues(new String[cells.length],cells);
					te = new TeacherExcelVO(values);
					teList.add(te);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(wb != null)
				try {
					wb.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return teList;
	}
	
	public static List<StudentExcelVO> readStudentFile(String filePath){
		StudentExcelVO st = null;
		List<StudentExcelVO> stList = new ArrayList<StudentExcelVO>();
		HSSFWorkbook wb = null;
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(filePath);
			wb = new HSSFWorkbook(inputStream);
			HSSFSheet sheet = wb.getSheetAt(0);
			
			for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
				HSSFCell[] cells = new HSSFCell[30];
				HSSFRow row = sheet.getRow(rowNum);
				if (row != null) {
					for(int i=0;i<cells.length;i++){
						cells[i] = row.getCell(i);
					}
					String[] values = getHSSFCellValues(new String[cells.length],cells);
					st = new StudentExcelVO(values);
					stList.add(st);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(wb != null)
				try {
					wb.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return stList;
	}
	
	private static String[] getHSSFCellValues(String[] values,HSSFCell...cells) {
		DecimalFormat df = new DecimalFormat("0");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0;i<cells.length;i++){
			if(cells[i]!=null){
				if (cells[i].getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
					values[i] = String.valueOf(cells[i].getBooleanCellValue());
				} else if (cells[i].getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
					if(HSSFDateUtil.isCellDateFormatted(cells[i])){
						values[i] = sdf.format(HSSFDateUtil.getJavaDate(cells[i].getNumericCellValue())).toString();
					}else{
						values[i] = String.valueOf(df.format(cells[i].getNumericCellValue()));
					}
				} else {
					values[i] = String.valueOf(cells[i].getStringCellValue());
				}
			}else{
				values[i] = "";
			}
		}
		return values;
	}
	
	private static String getHSSFCellValue(HSSFCell cell) {
		if(cell ==null) return null;
		if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
			return String.valueOf(cell.getNumericCellValue());
		} else {
			return String.valueOf(cell.getStringCellValue());
		}
	}
}
