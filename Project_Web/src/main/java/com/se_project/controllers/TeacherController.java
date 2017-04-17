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
import com.se_project.models.Teacher;

@Controller
public class TeacherController {
	
	@Autowired
	TeacherRepositoryService teacherRepoService;

	@Autowired
	StudentRepositoryService studentRepoService;
	
	
	@RequestMapping(value = "/teacher_signup_form",method = RequestMethod.GET)
	public String get_signup_form(Teacher teacher){
		return "Authentication/teacher_sign_up_form";
	}
	

	@RequestMapping(value = "/teacher_signup_form",method = RequestMethod.POST)
	public String sign_up(@Valid Teacher teacher,BindingResult bindingResult, Model model){
		
		if(bindingResult.hasErrors())
			return "Authentication/teacher_sign_up_form";
		else if(!Validate(teacher.getUsername()))
		{
			model.addAttribute("Wrongusername",true);
			return "Authentication/teacher_sign_up_form";
		}
		else if(!teacher.getPassword().equals(teacher.getConfirmPassword()))
		{
			model.addAttribute("MismatchPassword",true);
			return "Authentication/teacher_sign_up_form";
		}
		
		
		teacherRepoService.addTeacher(teacher);
		model.addAttribute("Teacher",teacher);
		return "Teacher/T_Homepage";
	}
	

	public boolean Validate(String username){
		
		if(studentRepoService.getStudent(username) != null || 
				teacherRepoService.getTeacher(username) != null)
			return false;
			
		return true;
	}
}
