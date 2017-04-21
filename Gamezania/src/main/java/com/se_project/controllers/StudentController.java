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

/**
 * This class implements the controller functions that link between the student
 * model and its views.
 *
 */
@Controller
public class StudentController {

	@Autowired
	StudentRepositoryService studentRepoService;

	@Autowired
	TeacherRepositoryService teacherRepoService;

	/**
	 *
	 * @param student
	 *            object of the student who registers in the system
	 * @return HTML page contains the form of registration
	 */
	@RequestMapping(value = "/student_signup_form", method = RequestMethod.GET)
	public String get_signup_form(Student student) {
		return "Authentication/student_sign_up_form";
	}

	/**
	 * this function takes the data from the student and creates an account for
	 * him
	 * 
	 * @param student
	 *            object of the student who registers in the system
	 * @return HTML page of the registered student home-page 
         * or returns HTML page of the registration form if the data entered is wong 
	 */
	@RequestMapping(value = "/student_signup_form", method = RequestMethod.POST)
	public String sign_up(Student student, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors())
			return "Authentication/student_sign_up_form";
		else if (!Validate(student.getUsername())) {
			model.addAttribute("Wrongusername", true);
			return "Authentication/student_sign_up_form";
		} else if (!student.getPassword().equals(student.getConfirmPassword())) {
			model.addAttribute("MismatchPassword", true);
			return "Authentication/student_sign_up_form";
		}

		return "redirect:/user/" + student.getUsername();
	}

	/**
	 * this function validate the given user-name of a user by checking 
	 * if it already exists in the system or not
	 * 
	 * @param username
	 *            holds the user-name of a user(student or teacher)
	 * @return boolean value (true or false)
	 */
	public boolean Validate(String username) {

		if (studentRepoService.getStudent(username) != null || teacherRepoService.getTeacher(username) != null)
			return false;

		return true;
	}
}
