package com.se_project.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.se_project.controllers.services.CourseRepositoryService;
import com.se_project.controllers.services.StudentRepositoryService;
import com.se_project.controllers.services.TeacherRepositoryService;
import com.se_project.models.Course;
import com.se_project.models.Student;
import com.se_project.models.Teacher;
import com.se_project.models.User;

/**
 * This class implements the controller functions that link between the user
 * model and its views.
 *
 */
@Controller
public class UserController {
	public static String current_user = "";
	@Autowired
	StudentRepositoryService studentRepoService;

	@Autowired
	TeacherRepositoryService teacherRepoService;

	@Autowired
	CourseRepositoryService courseRepoService;

	/**
	 * @return HTML page of the main home-page of the web-site
	 */
	@RequestMapping("/")
	public String getHomepage() {
		return "HomePage/index";
	}

	/**
	 * this function get all the courses that exists in the system and show it
	 * in the main page of a user
	 * 
	 * @param user_id
	 *            holds the user id that identifies the user through the system
	 * @return HTML page of a user(student or teacher) home-page that shows all
	 *         the courses that is exists in the system (depends on the type of the user)
	 */
	@RequestMapping("/user/{user_id}")
	public String get_homepage(@PathVariable String user_id, Model model) {
		if(!current_user.equals(user_id))
			return "redirect:/";
		
		List<Course> courses = new ArrayList<Course>(courseRepoService.getAllCourses());
		Teacher teacher = isTeacher(user_id);

		if (teacher != null) {
			model.addAttribute("Teacher", teacher);
			model.addAttribute("courses", courses);
			return "Teacher/T_Homepage";
		} else {
			model.addAttribute("Student", studentRepoService.getStudent(user_id));
			model.addAttribute("courses", courses);
			return "Student/S_Homepage";
		}
	}

	/**
	 * @param user
	 *            object of the user who signs in to the web-site
	 * @return HTML page contains the login form
	 */
	@RequestMapping("/sign_in")
	public String get_Signin_form(User user) {
		return "Authentication/sign_in_form";
	}
	
	@RequestMapping("/logout")
	public String logout(){
		current_user = "";
		return "redirect:/";
	}

	/**
	 * this function takes the user-name and password from a user to open his
	 * account on the web-site
	 * 
	 * @param user
	 *            object of the user who signs in to the web-site
	 * @return HTML page of a user home-page or returns the login form again if
	 *         the entered data is wrong
	 */
	@RequestMapping(value = "/sign_in", method = RequestMethod.POST)
	public String sign_in(User user, Model model) {

		Student student = isStudent(user.getUsername());
		Teacher teacher = isTeacher(user.getUsername());
		if (student != null && student.getPassword().equals(user.getPassword())) {
			current_user = user.getUsername();
			return "redirect:/user/" + student.getUsername();
		} else if (teacher != null && teacher.getPassword().equals(user.getPassword())) {
			current_user = user.getUsername();
			return "redirect:/user/" + teacher.getUsername();
		} else {
			model.addAttribute("Wrongdata", true);
			return "Authentication/sign_in_form";
		}
	}

	/**
	 * @param username holds the user-name of student
	 * @return object of the student that contains his data 
	 */
	public Student isStudent(String username) {
		return studentRepoService.getStudent(username);
	}
	/**
	 * @param username holds the user-name of a student
	 * @return object of the teacher that contains his data 
	 */
	public Teacher isTeacher(String username) {
		return teacherRepoService.getTeacher(username);
	}

}
