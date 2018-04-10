package com.spring.people.management.app.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "personId")
	private int id;

	@Column(name = "firstName",length = 60,nullable = false)
	private  String firstName;

	@Column(name = "lastName")
	private  String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "creationDate")
	private Date creationDate;

	public Person() {
	}

	public Person(String firstName, String lastName, String email, Date creationDate) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.creationDate = creationDate;
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
