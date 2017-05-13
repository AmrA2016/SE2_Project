package com.se_project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity(name = "comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long commentId;

	@ManyToOne
	Student student;
	String comment;	
	long gid;

	/**
	 * 
	 */
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param student
	 * @param comment
	 * @param gid
	 */
	public Comment(long id, Student student, String comment, long gid) {
		super();
		this.commentId = id;
		this.student = student;
		this.comment = comment;
		this.gid = gid;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student
	 *            the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return commentId;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.commentId = id;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the gid
	 */
	public long getGid() {
		return gid;
	}

	/**
	 * @param gid
	 *            the gid to set
	 */
	public void setGid(long gid) {
		this.gid = gid;
	}

}
