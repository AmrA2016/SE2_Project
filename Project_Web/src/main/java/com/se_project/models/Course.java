package com.se_project.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
	@Id
	private String id;
	private String name;
	private String description;
	private int ageRestriction;

	public Course() {

	}

	public Course(String id, String name, String description, int ageRestriction) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.ageRestriction = ageRestriction;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return ageRestriction;
	}

	public void setAgeRestriction(int ageRestriction) {
		this.ageRestriction = ageRestriction;
	}

}
