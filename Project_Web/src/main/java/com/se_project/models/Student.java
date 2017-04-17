package com.se_project.models;


import java.util.Date;

import javax.persistence.Entity;

@Entity(name="students")
public class Student extends User{
	
	private String intersets;
	private int score;
	
	public Student(){
		super();
	}
	
	public Student(String username, String firstname, String lastname, String password, String email, Date date,
			String gender) {
		super(username, firstname, lastname, password, email, date, gender);
	}

	public String getIntersets() {
		return intersets;
	}

	public void setIntersets(String intersets) {
		this.intersets = intersets;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	

}
