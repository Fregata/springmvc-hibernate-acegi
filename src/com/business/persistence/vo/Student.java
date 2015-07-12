package com.business.persistence.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1522996775888011768L;
	private Integer id;
	private String code;
	private String name;
	private String gender;
	private Date birthDate;
	private String phone;
	private String email;
	private String rollNo;
	private String nativePlace;
	private String IDCard;
	private String address;
	private String zipCode;
	private String status;
	private String familyType;
	private String knowledgeLevel;
	private String originAttr;
	private String position;
	private Date onboardDate;
	private Date deboardDate;
	private String ethinc;
	private String bloodCatalog;
	private String nativeAddress;
	private String nativeZipCode;
	private String telNo;
	private String imNo;
	private String remark;
	
	private StudentActivity stuActivity;
	private Set<Guardian> guardians = new HashSet<Guardian>();
	
	public Student() {}
	
	public Student(String code, String name, String gender, Date birthDate,
			String phone, String email, String rollNo, String nativePlace,
			String iDCard, String address, String zipCode, String status,
			String familyType, String knowledgeLevel, String originAttr,
			String position, Date onboardDate, Date deboardDate, String ethinc,
			String bloodCatalog, String nativeAddress, String nativeZipCode,
			String telNo, String imNo, String remark) {
		this.code = code;
		this.name = name;
		this.gender = gender;
		this.birthDate = birthDate;
		this.phone = phone;
		this.email = email;
		this.rollNo = rollNo;
		this.nativePlace = nativePlace;
		IDCard = iDCard;
		this.address = address;
		this.zipCode = zipCode;
		this.status = status;
		this.familyType = familyType;
		this.knowledgeLevel = knowledgeLevel;
		this.originAttr = originAttr;
		this.position = position;
		this.onboardDate = onboardDate;
		this.deboardDate = deboardDate;
		this.ethinc = ethinc;
		this.bloodCatalog = bloodCatalog;
		this.nativeAddress = nativeAddress;
		this.nativeZipCode = nativeZipCode;
		this.telNo = telNo;
		this.imNo = imNo;
		this.remark = remark;
	}

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
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFamilyType() {
		return familyType;
	}
	public void setFamilyType(String familyType) {
		this.familyType = familyType;
	}
	public String getKnowledgeLevel() {
		return knowledgeLevel;
	}
	public void setKnowledgeLevel(String knowledgeLevel) {
		this.knowledgeLevel = knowledgeLevel;
	}
	public String getOriginAttr() {
		return originAttr;
	}
	public void setOriginAttr(String originAttr) {
		this.originAttr = originAttr;
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
	public String getEthinc() {
		return ethinc;
	}
	public void setEthinc(String ethinc) {
		this.ethinc = ethinc;
	}
	public String getBloodCatalog() {
		return bloodCatalog;
	}
	public void setBloodCatalog(String bloodCatalog) {
		this.bloodCatalog = bloodCatalog;
	}
	public String getNativeAddress() {
		return nativeAddress;
	}
	public void setNativeAddress(String nativeAddress) {
		this.nativeAddress = nativeAddress;
	}
	public String getNativeZipCode() {
		return nativeZipCode;
	}
	public void setNativeZipCode(String nativeZipCode) {
		this.nativeZipCode = nativeZipCode;
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
	public StudentActivity getStuActivity() {
		return stuActivity;
	}
	public void setStuActivity(StudentActivity stuActivity) {
		this.stuActivity = stuActivity;
	}
	public Set<Guardian> getGuardians() {
		return guardians;
	}
	public void setGuardians(Set<Guardian> guardians) {
		this.guardians = guardians;
	}
	
	
}
