package com.se_project.models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * This represents the teacher entity in the system
 * <p>
 * It holds all the attributes related to the teacher only
 */

@Entity(name="teachers")
public class Teacher extends User{
	
	@NotEmpty
	private String mobile;
	@Column(name="teachingfield")
	private String experience;
	
	
	public Teacher() {
		super();
	}
	
	public Teacher(String teacher_username){
		super(teacher_username);
	}
	
	public Teacher(String username, String firstname, String lastname, String password, String email, Date date,
			String gender, String mob, String exp) {
		super(username, firstname, lastname, password, email, date, gender);
		
		mobile = mob;
		experience = exp;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String exprience) {
		this.experience = exprience;
	}
	
}
