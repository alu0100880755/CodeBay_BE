package com.init.users.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	// Attributes
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(name = "name", nullable = false, length = 30)
	private String Name;

	@Column(name = "surname", nullable = false, length = 30)
	private String Surname;

	@Column(name = "email", nullable = false, length = 30)
	private String Email;

	@Column(name = "city", nullable = false, length = 30)
	private String City;

	@Column(name = "active", nullable = false, length = 30)
	private Boolean Active;

	@Column(name = "birthday", nullable = false, length = 30)
	private String Birthday;

	@Column(name = "creation_date", nullable = false, length = 30)
	private LocalDateTime Creation_Date;

	// Getter & Setters
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public Boolean getActive() {
		return Active;
	}

	public void setActive(Boolean active) {
		Active = active;
	}

	public String getBirthday() {
		return Birthday;
	}

	public void setBirthday(String birthday) {
		Birthday = birthday;
	}

	public LocalDateTime getCreation_Date() {
		return Creation_Date;
	}

	public void setCreation_Date(LocalDateTime creation_Date) {
		Creation_Date = creation_Date;
	}

}
