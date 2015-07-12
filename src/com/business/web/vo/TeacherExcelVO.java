package com.business.web.vo;

import java.io.Serializable;

public class TeacherExcelVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1658641196896381348L;
	
	//class information
	private String classID;
	private String classCode;
	private String className;
	
	//subject information
	private String subjectID;
	private String subjectName;
	 
	//teacher information
	/*
	 * 身份证、民族、生日、籍贯、毕业学校（选择下拉框）、专业、教师学历、教师状态、是否有上岗证、岗位性质、职称、职务、任教起始日期、入校日期、离校日期、家庭住址、邮编、固定电话、手机、即时通讯号、备注
	 */
	private String teaCode;
	private String teaName;
	private String teaGender;
	private String teaBirthDate;
	private String teaPhone;
	private String teaEmail;
	private String startDate;
	private String finishDate;
	private String teaIDCard;
	private String teaEthinc;
	private String teaNativePlace;
	private String teaCollege;
	private String teaMajor;
	private String teaDegree;
	private String teaStatus;
	private String teaCertificate;
	private String teaPostProp;
	private String teaJobTitle;
	private String teaPosition;
	private String teaOnboardDate;
	private String teaDeboardDate;
	private String teaAddress;
	private String teaZipCode;
	private String teaTelNo;
	private String teaIMNo;
	private String teaRemark;
	
	
	//valid
	private String isValid;
	
	public TeacherExcelVO(String...values) {
		this.classID          = values[0];
		this.classCode        = values[1];
		this.className        = values[2];
		this.subjectID        = values[3];
		this.subjectName      = values[4];
		this.teaCode          = values[5];
		this.teaName          = values[6];
		this.teaGender        = values[7];
		this.teaBirthDate     = values[8];
		this.teaPhone         = values[9];
		this.teaEmail         = values[10];
		this.startDate        = values[11];
		this.finishDate       = values[12];
		this.teaIDCard        = values[13];
		this.teaEthinc        = values[14];
		this.teaNativePlace   = values[15];
		this.teaCollege       = values[16];
		this.teaMajor         = values[17];
		this.teaDegree        = values[18];
		this.teaStatus        = values[19];
		this.teaCertificate   = values[20];
		this.teaPostProp      = values[21];
		this.teaJobTitle      = values[22];
		this.teaPosition      = values[23];
		this.teaOnboardDate   = values[24];
		this.teaDeboardDate   = values[25];
		this.teaAddress       = values[26];
		this.teaZipCode       = values[27];
		this.teaTelNo         = values[28];
		this.teaIMNo          = values[29];
		this.teaRemark        = values[30];
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
	public String getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getTeaCode() {
		return teaCode;
	}
	public void setTeaCode(String teaCode) {
		this.teaCode = teaCode;
	}
	public String getTeaName() {
		return teaName;
	}
	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}
	public String getTeaGender() {
		return teaGender;
	}
	public void setTeaGender(String teaGender) {
		this.teaGender = teaGender;
	}
	public String getTeaBirthDate() {
		return teaBirthDate;
	}
	public void setTeaBirthDate(String teaBirthDate) {
		this.teaBirthDate = teaBirthDate;
	}
	public String getTeaPhone() {
		return teaPhone;
	}
	public void setTeaPhone(String teaPhone) {
		this.teaPhone = teaPhone;
	}
	public String getTeaEmail() {
		return teaEmail;
	}
	public void setTeaEmail(String teaEmail) {
		this.teaEmail = teaEmail;
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

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	
	
	public String getTeaIDCard() {
		return teaIDCard;
	}

	public void setTeaIDCard(String teaIDCard) {
		this.teaIDCard = teaIDCard;
	}

	public String getTeaEthinc() {
		return teaEthinc;
	}

	public void setTeaEthinc(String teaEthinc) {
		this.teaEthinc = teaEthinc;
	}

	public String getTeaNativePlace() {
		return teaNativePlace;
	}

	public void setTeaNativePlace(String teaNativePlace) {
		this.teaNativePlace = teaNativePlace;
	}

	public String getTeaCollege() {
		return teaCollege;
	}

	public void setTeaCollege(String teaCollege) {
		this.teaCollege = teaCollege;
	}

	public String getTeaMajor() {
		return teaMajor;
	}

	public void setTeaMajor(String teaMajor) {
		this.teaMajor = teaMajor;
	}

	public String getTeaDegree() {
		return teaDegree;
	}

	public void setTeaDegree(String teaDegree) {
		this.teaDegree = teaDegree;
	}

	public String getTeaStatus() {
		return teaStatus;
	}

	public void setTeaStatus(String teaStatus) {
		this.teaStatus = teaStatus;
	}

	public String getTeaCertificate() {
		return teaCertificate;
	}

	public void setTeaCertificate(String teaCertificate) {
		this.teaCertificate = teaCertificate;
	}

	public String getTeaPostProp() {
		return teaPostProp;
	}

	public void setTeaPostProp(String teaPostProp) {
		this.teaPostProp = teaPostProp;
	}

	public String getTeaJobTitle() {
		return teaJobTitle;
	}

	public void setTeaJobTitle(String teaJobTitle) {
		this.teaJobTitle = teaJobTitle;
	}

	public String getTeaPosition() {
		return teaPosition;
	}

	public void setTeaPosition(String teaPosition) {
		this.teaPosition = teaPosition;
	}

	public String getTeaOnboardDate() {
		return teaOnboardDate;
	}

	public void setTeaOnboardDate(String teaOnboardDate) {
		this.teaOnboardDate = teaOnboardDate;
	}

	public String getTeaDeboardDate() {
		return teaDeboardDate;
	}

	public void setTeaDeboardDate(String teaDeboardDate) {
		this.teaDeboardDate = teaDeboardDate;
	}

	public String getTeaAddress() {
		return teaAddress;
	}

	public void setTeaAddress(String teaAddress) {
		this.teaAddress = teaAddress;
	}

	public String getTeaZipCode() {
		return teaZipCode;
	}

	public void setTeaZipCode(String teaZipCode) {
		this.teaZipCode = teaZipCode;
	}

	public String getTeaTelNo() {
		return teaTelNo;
	}

	public void setTeaTelNo(String teaTelNo) {
		this.teaTelNo = teaTelNo;
	}

	public String getTeaIMNo() {
		return teaIMNo;
	}

	public void setTeaIMNo(String teaIMNo) {
		this.teaIMNo = teaIMNo;
	}

	public String getTeaRemark() {
		return teaRemark;
	}

	public void setTeaRemark(String teaRemark) {
		this.teaRemark = teaRemark;
	}

}
