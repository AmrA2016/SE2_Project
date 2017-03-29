
package com.se_project.controllers.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.se_project.models.Course;
import com.se_project.repositories.CourseRepository;

@Service
public class CourseRepositoryService {


	@Autowired
	private CourseRepository courseRepo;
	
	public void CreateCourse(Course course){
		courseRepo.save(course);
	}
	public Course getCourse(String id){
		return courseRepo.findOne(id);
	}
	public List<Course> ShowCourses() {
		List<Course>courses =new ArrayList<>();
		courseRepo.findAll().forEach(courses::add);
		return courses;
	}

	public boolean ValidateName(String name) {
	
		if(courseRepo.findOne(name)!=null)
			return false;
		else
			return true;
			
			
		
	}


}