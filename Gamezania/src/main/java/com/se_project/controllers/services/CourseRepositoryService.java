
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

/**
 * The class implements the needed operations for handling the Course repository 
 * as saving them in database or retrieving them
 */
@Service
public class CourseRepositoryService {


	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private ImageService imageService;
	
	/**
	 * Save a course object in database
	 * @param course the course object to be saved
	 */
	public void CreateCourse(Course course){
		courseRepo.save(course);
	}
	
	/**
	 * Get course object by id
	 * @param id the id of the course to be retrieved
	 * @return course object
	 */
	public Course getCourse(long id){
		return courseRepo.findOne(id);
	}
	
	/**
	 * @param name
	 * @return
	 */
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
	public List<Course> getCoursesByCategory(String category){
		List<Course>courses =new ArrayList<>();
		courseRepo.getCoursesByCategory(category).forEach(courses::add);
		return courses;
	}
	
	public void deleteCourse(long cid){
		String imageName = courseRepo.findOne(cid).getImage();
		courseRepo.delete(cid);
		imageService.deleteImage(imageName);
	}


}