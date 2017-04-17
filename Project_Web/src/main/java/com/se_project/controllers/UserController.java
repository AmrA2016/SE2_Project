package com.se_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.se_project.controllers.services.StudentRepositoryService;
import com.se_project.controllers.services.TeacherRepositoryService;
import com.se_project.models.Student;
import com.se_project.models.Teacher;
import com.se_project.models.User;

@Controller
public class UserController {
	
	@Autowired
	StudentRepositoryService studentRepoService;
	
	@Autowired
	TeacherRepositoryService teacherRepoService;
	
	@RequestMapping("/")
	public String getHomepage(){
		return "HomePage/index";
	}
	
	@RequestMapping("/user/{user_id}")
	public String get_homepage(@PathVariable String user_id, Model model){
		Teacher teacher = isTeacher(user_id);
		if(teacher != null){
			model.addAttribute("Teacher",teacher);
			return "Teacher/T_Homepage";
		}
		else
		{
			model.addAttribute("Student",studentRepoService.getStudent(user_id));
			return "Student/S_Homepage";
		}
	}
	
	@RequestMapping("/sign_in")
	public String get_Signin_form(User user){
		return "Authentication/sign_in_form";
	}
	
	
	@RequestMapping(value="/sign_in", method=RequestMethod.POST)
	public String sign_in(User user, Model model){
		
		Student student = isStudent(user.getUsername());
		Teacher teacher = isTeacher(user.getUsername());
		if(student != null && student.getPassword().equals(user.getPassword())){
			model.addAttribute("Student",student);
			return "Student/S_Homepage";
		}
		else if(teacher != null && teacher.getPassword().equals(user.getPassword())){
			
			model.addAttribute("Teacher",teacher);
			return "Teacher/T_Homepage";
		}
		else{
			model.addAttribute("Wrongdata",true);
			return "Authentication/sign_in_form";
		}
	}
	
	
	public Student isStudent(String username){
		return studentRepoService.getStudent(username);
	}
	
	public Teacher isTeacher(String username){
		return teacherRepoService.getTeacher(username);
	}

}
