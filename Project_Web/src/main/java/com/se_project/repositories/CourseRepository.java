package com.se_project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.se_project.models.Course;


public interface CourseRepository extends CrudRepository<Course,Long>{
	public List<Course> findByTeacherUsername (String name);
	public Course findByName(String name);
}
