package com.business.persistence.vo;

import java.io.Serializable;
import java.util.Date;

public class Teacher implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1134382055571508633L;
	private Integer id;
	private String code;
	private String name;
	private String gender;
	private Date birthDate;
	private String phone;
	private String email;
	private String IDCard;
	private String ethinc;
	private String nativePlace;
	private String college;
	private String major;
	private String degree;
	private String status;
	private String certificate;
	private String postProp;
	private String jobTitle;
	private String position;
	private Date onboardDate;
	private Date deboardDate;
	private String address;
	private String zipCode;
	private String telNo;
	private String imNo;
	private String remark;
	private TeacherActivity teaActivity;
	private SubjectActivity subActivity;
	
	public Teacher(String code, String name, String gender, Date birthDate,
			String phone, String email, String iDCard, String ethinc,
			String nativePlace, String college, String major, String degree,
			String status, String certificate, String postProp,
			String jobTitle, String position, Date onboardDate,
			Date deboardDate, String address, String zipCode, String telNo,
			String imNo, String remark){
		this.code = code;
		this.name = name;
		this.gender = gender;
		this.birthDate = birthDate;
		this.phone = phone;
		this.email = email;
		IDCard = iDCard;
		this.ethinc = ethinc;
		this.nativePlace = nativePlace;
		this.college = college;
		this.major = major;
		this.degree = degree;
		this.status = status;
		this.certificate = certificate;
		this.postProp = postProp;
		this.jobTitle = jobTitle;
		this.position = position;
		this.onboardDate = onboardDate;
		this.deboardDate = deboardDate;
		this.address = address;
		this.zipCode = zipCode;
		this.telNo = telNo;
		this.imNo = imNo;
		this.remark = remark;
	}
	
	public Teacher() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}
	public String getEthinc() {
		return ethinc;
	}
	public void setEthinc(String ethinc) {
		this.ethinc = ethinc;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public String getPostProp() {
		return postProp;
	}
	public void setPostProp(String postProp) {
		this.postProp = postProp;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Date getOnboardDate() {
		return onboardDate;
	}
	public void setOnboardDate(Date onboardDate) {
		this.onboardDate = onboardDate;
	}
	public Date getDeboardDate() {
		return deboardDate;
	}
	public void setDeboardDate(Date deboardDate) {
		this.deboardDate = deboardDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public String getImNo() {
		return imNo;
	}
	public void setImNo(String imNo) {
		this.imNo = imNo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public TeacherActivity getTeaActivity() {
		return teaActivity;
	}
	public void setTeaActivity(TeacherActivity teaActivity) {
		this.teaActivity = teaActivity;
	}
	public SubjectActivity getSubActivity() {
		return subActivity;
	}
	public void setSubActivity(SubjectActivity subActivity) {
		this.subActivity = subActivity;
	}
	
}
