package com.se_project.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.se_project.controllers.services.StudentRepositoryService;
import com.se_project.models.Post;
import com.se_project.models.Student;
import com.se_project.models.User;

@Controller
public class StudentController {
	
	@Autowired
	StudentRepositoryService studentRepoService;
	
	@RequestMapping(value = "/student_signup_form",method = RequestMethod.GET)
	public String get_signup_form(User user){
		return "student_sign_up_form";
	}
	

	@RequestMapping(value = "/student_signup_form",method = RequestMethod.POST)
	public String sign_up(@Valid Student student,BindingResult bindingResult){
		if(bindingResult.hasErrors())
			return "student_sign_up_form";
		
		studentRepoService.addStudent(student);
		Student s = studentRepoService.getStudent(student.getUsername());
		System.out.println(s.getEmail());
		return "result";
	}
}
