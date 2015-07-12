package com.business.web.vo;

import java.io.Serializable;
import java.util.Date;

public class StudentExcelVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5632316773876410570L;
	
	//class information
	private String classID;
	private String classCode;
	private String className;

	//student information
	/*
	 * 学籍号、学号、籍贯、身份证、出生日期、家庭住址、邮编、学生状态、家庭类型、知识等级、生源性质、学生职务、入校日期、离校日期、民族、血型、户籍地址、户籍邮编、固定电话、手机、即时通讯、备注
	 */
	private String stuCode;
	private String stuName;
	private String stuGender;
	private String stuBirthDate;
	private String stuPhone;
	private String stuEmail;
	private String startDate;
	private String finishDate;
	private String stuRollNo;
	private String stuNative;       
	private String stuIDCard;       
	private String stuAddress;       
	private String stuZipCode;       
	private String stuStatus;        
	private String stuFamilyType;    
	private String stuKnowledgeLevel;
	private String stuOriginAttr;    
	private String stuPosition;      
	private String stuOnboardDate;   
	private String stuDeboardDate;   
	private String stuEthinc;        
	private String stuBloodCatalog;  
	private String stuNativeAddress; 
	private String stuNativeZipCode; 
	private String stuTelNo;         
	private String stuIMNo;          
	private String stuRemark;        
	//valid
	private String isValid;
	
	public StudentExcelVO(String...values) {
		this.classID             = values[0];
		this.classCode           = values[1];
		this.className           = values[2];
		this.stuCode             = values[3];
		this.stuName             = values[4];
		this.stuGender           = values[5];
		this.stuBirthDate        = values[6];
		this.stuPhone            = values[7];
		this.stuEmail            = values[8];
		this.startDate           = values[9];
		this.finishDate          = values[10];
		this.stuRollNo 		     = values[11];
		this.stuNative           = values[12];
		this.stuIDCard           = values[13];
		this.stuAddress          = values[14];
		this.stuZipCode          = values[15];
		this.stuStatus           = values[16];
		this.stuFamilyType       = values[17];
		this.stuKnowledgeLevel   = values[18];
		this.stuOriginAttr       = values[19];
		this.stuPosition         = values[20];
		this.stuOnboardDate      = values[21];
		this.stuDeboardDate      = values[22];
		this.stuEthinc           = values[23];
		this.stuBloodCatalog     = values[24];
		this.stuNativeAddress    = values[25];
		this.stuNativeZipCode    = values[26];
		this.stuTelNo            = values[27];
		this.stuIMNo             = values[28];
		this.stuRemark           = values[29];
	}

	public String getClassID() {
		return classID;
	}

	public void setClassID(String classID) {
		this.classID = classID;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getStuCode() {
		return stuCode;
	}

	public void setStuCode(String stuCode) {
		this.stuCode = stuCode;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuGender() {
		return stuGender;
	}

	public void setStuGender(String stuGender) {
		this.stuGender = stuGender;
	}

	public String getStuBirthDate() {
		return stuBirthDate;
	}

	public void setStuBirthDate(String stuBirthDate) {
		this.stuBirthDate = stuBirthDate;
	}

	public String getStuPhone() {
		return stuPhone;
	}

	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}

	public String getStuEmail() {
		return stuEmail;
	}

	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}

	public String getStuRollNo() {
		return stuRollNo;
	}

	public void setStuRollNo(String stuRollNo) {
		this.stuRollNo = stuRollNo;
	}

	public String getStuNative() {
		return stuNative;
	}

	public void setStuNative(String stuNative) {
		this.stuNative = stuNative;
	}

	public String getStuIDCard() {
		return stuIDCard;
	}

	public void setStuIDCard(String stuIDCard) {
		this.stuIDCard = stuIDCard;
	}

	public String getStuAddress() {
		return stuAddress;
	}

	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}

	public String getStuZipCode() {
		return stuZipCode;
	}

	public void setStuZipCode(String stuZipCode) {
		this.stuZipCode = stuZipCode;
	}

	public String getStuStatus() {
		return stuStatus;
	}

	public void setStuStatus(String stuStatus) {
		this.stuStatus = stuStatus;
	}

	public String getStuFamilyType() {
		return stuFamilyType;
	}

	public void setStuFamilyType(String stuFamilyType) {
		this.stuFamilyType = stuFamilyType;
	}

	public String getStuKnowledgeLevel() {
		return stuKnowledgeLevel;
	}

	public void setStuKnowledgeLevel(String stuKnowledgeLevel) {
		this.stuKnowledgeLevel = stuKnowledgeLevel;
	}

	public String getStuOriginAttr() {
		return stuOriginAttr;
	}

	public void setStuOriginAttr(String stuOriginAttr) {
		this.stuOriginAttr = stuOriginAttr;
	}

	public String getStuPosition() {
		return stuPosition;
	}

	public void setStuPosition(String stuPosition) {
		this.stuPosition = stuPosition;
	}

	public String getStuOnboardDate() {
		return stuOnboardDate;
	}

	public void setStuOnboardDate(String stuOnboardDate) {
		this.stuOnboardDate = stuOnboardDate;
	}

	public String getStuDeboardDate() {
		return stuDeboardDate;
	}

	public void setStuDeboardDate(String stuDeboardDate) {
		this.stuDeboardDate = stuDeboardDate;
	}

	public String getStuEthinc() {
		return stuEthinc;
	}

	public void setStuEthinc(String stuEthinc) {
		this.stuEthinc = stuEthinc;
	}

	public String getStuBloodCatalog() {
		return stuBloodCatalog;
	}

	public void setStuBloodCatalog(String stuBloodCatalog) {
		this.stuBloodCatalog = stuBloodCatalog;
	}

	public String getStuNativeAddress() {
		return stuNativeAddress;
	}

	public void setStuNativeAddress(String stuNativeAddress) {
		this.stuNativeAddress = stuNativeAddress;
	}

	public String getStuNativeZipCode() {
		return stuNativeZipCode;
	}

	public void setStuNativeZipCode(String stuNativeZipCode) {
		this.stuNativeZipCode = stuNativeZipCode;
	}

	public String getStuTelNo() {
		return stuTelNo;
	}

	public void setStuTelNo(String stuTelNo) {
		this.stuTelNo = stuTelNo;
	}

	public String getStuIMNo() {
		return stuIMNo;
	}

	public void setStuIMNo(String stuIMNo) {
		this.stuIMNo = stuIMNo;
	}

	public String getStuRemark() {
		return stuRemark;
	}

	public void setStuRemark(String stuRemark) {
		this.stuRemark = stuRemark;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	

	
}
