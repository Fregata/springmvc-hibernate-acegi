package com.business.persistence.vo;

public class Teacher {

	private Integer id;
	private String code;
	private String name;
	private String gender;
	private int age;
	private TeacherActivity teaActivity;
	private SubjectActivity subActivity;
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
