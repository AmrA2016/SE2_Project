package com.se_project.controllers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se_project.models.Teacher;
import com.se_project.repositories.TeacherRepository;

/**
 * The class implements the needed operations for handling the Teacher repository 
 * as saving them in database or retrieving them
 */
@Service
public class TeacherRepositoryService {
	
	@Autowired
	TeacherRepository teacherRepo;
	
	/**
	 * Stores a teacher object in the database
	 * @param t the teacher object to be saved
	 * @return the result of saving operation
	 */
	public boolean addTeacher(Teacher t){
		if(teacherRepo.save(t) != null)
			return true;
		else
			return false;
	}
	
	/**
	 * Get a teacher object from database given its name
	 * <p>
	 * Note: username is the primary key of the teacher
	 * @param username the username of the teacher to be retrieved
	 * @return teacher object from database
	 */
	public Teacher getTeacher(String username){
		return teacherRepo.findOne(username);
	}
}
