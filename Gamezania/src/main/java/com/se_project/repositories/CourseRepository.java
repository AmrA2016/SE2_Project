package com.se_project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.se_project.models.Course;


/**
 * this class handle database operations for mcqgames table 
 *
 */
public interface CourseRepository extends CrudRepository<Course,Long>{
        /**
	 * this function searches for a teacher by user-name
	 * 
	 * @param name
	 *            holds the teacher user-name
         *
	 * @return list of courses created by this teacher
	 */
	public List<Course> findByTeacherUsername (String name);
        /**
	 * this function searches for a course by name
	 * 
	 * @param name
	 *            holds the course name
         *
	 * @return object of the course which has all the course information
	 */
	public Course findByName(String name);
        /**
	 * this function searches for courses within a specific category
	 * 
	 * @param name
	 *            holds the category name
         *
	 * @return list of courses within this category
	 */
	public List<Course> getCoursesByCategory(String category);
}
