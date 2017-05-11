package com.se_project.controllers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se_project.models.Student;
import com.se_project.repositories.StudentRepository;

@Service
public class StudentRepositoryService {
	
	@Autowired
	StudentRepository studentRepo;
	
	/**
	 * Stores a student object in the database
	 * @param s the student object to be saved
	 * @return the result of saving operation
	 */
	public boolean addStudent(Student s){
		if(studentRepo.save(s) != null)
			return true;
		else
			return false;
	}
	
	/**
	 * Get a student object from database given its name
	 * <p>
	 * Note: username is the primary key of the student
	 * @param username the username of the student to be retrieved
	 * @return student object from database
	 */
	public Student getStudent(String username){
		return studentRepo.findOne(username);
	}
}
