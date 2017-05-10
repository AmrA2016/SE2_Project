package com.se_project.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * It represents the course entity in the system and it holds all the courses data
 * <p>
 * This class maps to 'courses' table in the database
 *
 */
@Entity(name="courses")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long cid;
	@NotEmpty
	@Size(min = 2, max = 50)
	private  String name;
	
	@NotEmpty
	@Size(max = 1000)
	private String description;
	
	@Min(5)
	private int age;
	@NotEmpty
	@Size(min = 3, max = 45)
	private String category;
	
    private String image;

	
    @ManyToOne
    private Teacher teacher;
    
    @Transient
    private List<CourseSubscriber> subscribers=new ArrayList<CourseSubscriber>();


	public Course() {

	}

	/**
	 * @param cid
	 * @param name
	 * @param description
	 * @param age
	 * @param category
	 * @param image
	 * @param teacher
	 * @param subscribers
	 */
	public Course(long cid, String name, String description, int age, String category, String image, Teacher teacher,
			List<CourseSubscriber> subscribers) {
		super();
		this.cid = cid;
		this.name = name;
		this.description = description;
		this.age = age;
		this.category = category;
		this.image = image;
		this.teacher = teacher;
		this.subscribers = subscribers;
	}

	/**
	 * @param name
	 * @param description
	 * @param age
	 * @param category
	 * @param image
	 */


	/**
	 * @return course id
	 */
	public long getCid() {
		return cid;
	}

	/**
	 * @param cid course_id to be set
	 */
	public void setCid(long cid) {
		this.cid = cid;
	}

	/**
	 * @return course name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return course age restriction
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param ageRestriction
	 */
	public void setAge(int ageRestriction) {
		this.age = ageRestriction;
	}

	/**
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * @return imagefile name
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image imagename to be set
	 */
	public void setImage(String image) {
		this.image = image;
	}


	/**
	 * @return Teacher object that owns this course
	 */
	public Teacher getTeacher() {
		return teacher;
	}

	/**
	 * @param teacher teacher_object to be set
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	/**
	 * @return the subscribers
	 */
	public List<CourseSubscriber> getSubscribers() {
		return subscribers;
	}

	/**
	 * @param subscribers the subscribers to set
	 */
	public void setSubscribers(List<CourseSubscriber> subscribers) {
		this.subscribers = subscribers;
	}
}
