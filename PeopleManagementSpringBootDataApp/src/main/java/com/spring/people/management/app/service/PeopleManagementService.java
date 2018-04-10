package com.spring.people.management.app.service;

import com.spring.people.management.app.dao.PeopleManagementDao;
import com.spring.people.management.app.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleManagementService {

	@Autowired
	PeopleManagementDao peopleMangementDao;

	public Person createPerson(Person person){
		return peopleMangementDao.save(person);
	}

	public List<Person> getPersonByLastName(String gupta) {
		List<Person> personList=peopleMangementDao.findByLastName(gupta);
		return personList;
	}
}
