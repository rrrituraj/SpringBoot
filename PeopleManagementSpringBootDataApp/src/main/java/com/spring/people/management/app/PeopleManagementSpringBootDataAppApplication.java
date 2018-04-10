package com.spring.people.management.app;

import com.spring.people.management.app.entities.Person;
import com.spring.people.management.app.service.PeopleManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class PeopleManagementSpringBootDataAppApplication implements CommandLineRunner {

	@Autowired
	PeopleManagementService peopleManagementService;

	public static void main(String[] args) {
		SpringApplication.run(PeopleManagementSpringBootDataAppApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
//		createPerson();
		getPersonByLastName();
	}

	private void getPersonByLastName() {
		List<Person> personList = peopleManagementService.getPersonByLastName("Gupta");
		personList.forEach(System.out::println);
	}

	private void createPerson() {
		Person person = new Person("Rituraj", "gupta", "guptamaharaj@gmail.com", new Date());
		Person personDb = peopleManagementService.createPerson(person);
		System.out.println(personDb);
	}
}
