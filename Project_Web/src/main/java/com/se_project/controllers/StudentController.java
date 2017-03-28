package com.se_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {
	
	@RequestMapping(value = "/student_signup_form",method = RequestMethod.GET)
	public String get_signup_form(){
		return "student_sign_up_form";
	}
}
