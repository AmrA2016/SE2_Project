package com.se_project.controllers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se_project.models.Teacher;
import com.se_project.repositories.TeacherRepository;

@Service
public class TeacherRepositoryService {
	
	@Autowired
	TeacherRepository teacherRepo;
	
	public boolean addTeacher(Teacher t){
		if(teacherRepo.save(t) != null)
			return true;
		else
			return false;
	}
	
	public Teacher getTeacher(String username){
		return teacherRepo.findOne(username);
	}
}
