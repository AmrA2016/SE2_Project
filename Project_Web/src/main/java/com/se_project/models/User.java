package com.se_project.models;


import java.util.Date;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public class User {
	@Id
	@NotEmpty(message = "*Username is required")
	protected String username;
	@NotEmpty
	protected String firstname;
	@NotEmpty
	protected String lastname;
	@NotEmpty
	@Size(min=6)
	protected String password;
	@Size(min=6)
	@Transient
	protected String confirmPassword;
	@Email
	@NotEmpty
	protected String email;
	@NotNull
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	protected Date birthdate;
	protected String gender;
	

	public User() {
	}
	
	public User(String username, String firstname, String lastname, String password, String email, Date date,
			String gender) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
		this.birthdate = date;
		this.gender = gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date date) {
		this.birthdate = date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
