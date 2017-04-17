package com.se_project.controllers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se_project.models.Student;
import com.se_project.repositories.StudentRepository;

@Service
public class StudentRepositoryService {
	
	@Autowired
	StudentRepository studentRepo;
	
	public boolean addStudent(Student s){
		if(studentRepo.save(s) != null)
			return true;
		else
			return false;
	}
	
	public Student getStudent(String username){
		return studentRepo.findOne(username);
	}
}
