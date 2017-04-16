
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
	public Course getCourse(long id){
		return courseRepo.findOne(id);
	}
	
	public Course getCourseByName (String name){
		return courseRepo.findByName(name);
	}
	public List<Course> getAllCourses() {
		List<Course>courses =new ArrayList<>();
		courseRepo.findAll().forEach(courses::add);
		return courses;
	}
	
	public List<Course> getCoursesByTeacher(String teacher_id){
		List<Course>courses =new ArrayList<>();
		courseRepo.findByTeacherUsername(teacher_id).forEach(courses::add);
		return courses;
	}
	
	public void deleteCourse(long cid){
		courseRepo.delete(cid);
	}


}