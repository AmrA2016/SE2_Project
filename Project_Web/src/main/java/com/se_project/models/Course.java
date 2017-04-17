package com.se_project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

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

	public Course() {

	}

	public Course( String name, String description, int age, String category,String image) {
		super();
		this.name = name;
		this.description = description;
		this.age = age;
		this.category = category;
		this.image = image;
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int ageRestriction) {
		this.age = ageRestriction;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}


}
