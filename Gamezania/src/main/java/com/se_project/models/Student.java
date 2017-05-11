package com.se_project.models;


import java.util.Date;

import javax.persistence.Entity;

/**
 * This represents the student entity in the system
 * <p>
 * It holds all the attributes related to the student only
 */

@Entity(name="students")
public class Student extends User{
	
	private String intersets;
	private int score;
	
	public Student(){
		super();
	}
	
	public Student(String student_username){
		super(student_username);
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
	public Student(String username, String firstname, String lastname, String password, String email, Date date,
			String gender) {
		super(username, firstname, lastname, password, email, date, gender);
	}

	/**
	 * @return the intersets
	 */
	public String getIntersets() {
		return intersets;
	}

	/**
	 * @param intersets the intersets to set
	 */
	public void setIntersets(String intersets) {
		this.intersets = intersets;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	

}
