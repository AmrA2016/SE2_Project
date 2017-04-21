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

/**
 * This class implements the controller functions that link between the teacher
 * model and its views.
 *
 */
@Controller
public class TeacherController {
	
	@Autowired
	TeacherRepositoryService teacherRepoService;

	@Autowired
	StudentRepositoryService studentRepoService;
	
	
	/**
	 * @param teacher object of the teacher who registers in the system
	 * @return  HTML page contains the form of registration
	 */
	@RequestMapping(value = "/teacher_signup_form",method = RequestMethod.GET)
	public String get_signup_form(Teacher teacher){
		return "Authentication/teacher_sign_up_form";
	}
	

	/**
	 * this function takes the data from the teacher and creates an account for
	 * him
	 * @param teacher object of the teacher who registers in the system
	 * @return HTML page of the registered teacher home-page
         * or returns HTML page of the registration form if the data entered is wrong
	 */
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
		
		return "redirect:/user/" + teacher.getUsername();

	}
	
	/**
	 * this function validate the given user-name of a user by checking 
	 * if it already exists in the system or not
	 * 
	 * @param username
	 *            holds the user-name of a user(student or teacher)
	 * @return boolean value (true or false)
	 */
	public boolean Validate(String username){
		
		if(studentRepoService.getStudent(username) != null || 
				teacherRepoService.getTeacher(username) != null)
			return false;
			
		return true;
	}
}
