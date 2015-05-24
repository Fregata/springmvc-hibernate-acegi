package com.business.service;

import java.util.List;

import com.business.persistence.vo.Person;
import com.framework.service.IBaseService;

public interface IPersonService extends IBaseService{

	Person get(Integer id);
	 
	void persistePerson(Person person);
	 
	void delete(Integer id);
	
	void delete(Person person);
	
	List<Person> findByName(String name);
	
	public List<Person> findAllPerson();
	
	long getPersonNumber();
}
