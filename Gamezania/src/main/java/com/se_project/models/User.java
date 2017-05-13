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

/**
 * This represents the user entity 
 * and it holds the generic attributes of the user
 * <p>
 * This entity doesn't stored in the database but its children are stored
 */
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
	/**
	 * It holds the password that user enter in confirmPassword field
	 * It just used for validation but not stored in the database
	 */
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
	
	public User(String username){
		this.username = username;
	}
	
	/**
	 * @param username
	 * @param firstname
	 * @param lastname
	 * @param password
	 * @param email
	 * @param date
	 * @param gender
	 */
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

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the birthdate
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	
}
