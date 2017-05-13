package com.se_project.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


@Entity(name="student_notification")
public class StudentNotification {

	@Id
	long id;
	
	private String msg;
	
	@ManyToOne
	private Student student;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * 
	 */
	public StudentNotification() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param student
	 * @param msg
	 */
	public StudentNotification(Student student, String msg) {
		super();
		this.student = student;
		this.msg = msg;
	}
	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}
	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}


}
