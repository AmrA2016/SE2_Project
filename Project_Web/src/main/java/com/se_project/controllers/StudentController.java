package com.se_project.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.se_project.controllers.services.StudentRepositoryService;
import com.se_project.controllers.services.TeacherRepositoryService;
import com.se_project.models.Student;


@Controller
public class StudentController {
	
	@Autowired
	StudentRepositoryService studentRepoService;
	
	@Autowired
	TeacherRepositoryService teacherRepoService;
	
	@RequestMapping(value = "/student_signup_form",method = RequestMethod.GET)
	public String get_signup_form(Student student){
		return "Authentication/student_sign_up_form";
	}
	

	@RequestMapping(value = "/student_signup_form",method = RequestMethod.POST)
	public String sign_up(Student student,BindingResult bindingResult,Model model){
		
		if(bindingResult.hasErrors())
			return "Authentication/student_sign_up_form";
		else if(!Validate(student.getUsername()))
		{
			model.addAttribute("Wrongusername",true);
			return "Authentication/student_sign_up_form";
		}
		else if(!student.getPassword().equals(student.getConfirmPassword()))
		{
			model.addAttribute("MismatchPassword",true);
			return "Authentication/student_sign_up_form";
		}
		
		studentRepoService.addStudent(student);
		model.addAttribute("Student",student);
		return "Student/S_Homepage";
	}
	
	public boolean Validate(String username){
		
		if(studentRepoService.getStudent(username) != null || 
				teacherRepoService.getTeacher(username) != null)
			return false;
			
		return true;
	}
}
