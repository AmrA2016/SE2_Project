package com.se_project.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Course {
	@NotEmpty
	@Size(min = 2, max = 40)
	@Id
	private  String name;
	@NotEmpty
	@Size(min = 10, max = 10000)
	private String description;
	
	@NotNull
	private Integer age;
	@NotEmpty
	@Size(min = 3, max = 30)
	private String category;
	
    private String image;

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

	public int getAgeRestriction() {
		return age;
	}

	public void setAgeRestriction(int ageRestriction) {
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


}
