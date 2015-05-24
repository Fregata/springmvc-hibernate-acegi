package com.business.persistence.vo;

import java.util.HashSet;
import java.util.Set;

public class Student {

	private Integer id;
	private String code;
	private String name;
	private String gender;
	private int age;
	private StudentActivity stuActivity;
	private Set<Guardian> guardians = new HashSet<Guardian>();
	
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
