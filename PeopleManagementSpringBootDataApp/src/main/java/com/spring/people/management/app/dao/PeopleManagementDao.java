package com.spring.people.management.app.dao;

import com.spring.people.management.app.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleManagementDao extends CrudRepository<Person,Integer> {

	List<Person> findByLastName(String s);
}
