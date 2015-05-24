package com.business.service.impl;

import java.util.List;

import com.business.persistence.vo.Person;
import com.business.service.IPersonService;
import com.framework.service.BaseService;

public class PersonService extends BaseService implements IPersonService {

	@Override
	public Person get(Integer id) {
		return (Person)this.load(Person.class, id);
	}

	@Override
	public void persistePerson(Person person) {
		this.saveOrUpdate(person);
	}

	@Override
	public void delete(Integer id) {
		this.delete(id);
	}

	@Override
	public void delete(Person person) {
		this.delete(person);
	}

	@Override
	public List<Person> findByName(String name) {
		return this.findByLike(Person.class, "name", name);
	}

	@Override
	public List<Person> findAllPerson() {
		return this.loadAll(Person.class);
	}

	@Override
	public long getPersonNumber() {
		return this.loadAll(Person.class).size();
	}

	
}
