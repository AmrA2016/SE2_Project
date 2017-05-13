package com.se_project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity(name="course_subscriber")
public class CourseSubscriber {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long subscriber_id;

	
	@OneToOne
	private Student student;

	@ManyToOne
	private Course course;
	
	
	public CourseSubscriber() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseSubscriber(long subscriberID, Student student, Course course) {
		super();
		this.subscriber_id = subscriberID;
		this.student = student;
		this.course = course;
	}

	public long getSubscriberID() {
		return subscriber_id;
	}

	public void setSubscriberID(long subscriberID) {
		this.subscriber_id = subscriberID;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}

