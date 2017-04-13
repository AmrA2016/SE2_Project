package com.se_project.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.se_project.controllers.services.CourseRepositoryService;
import com.se_project.controllers.services.TeacherRepositoryService;
import com.se_project.models.Course;
import com.se_project.models.Teacher;

@Controller
public class CourseController {
	
	@Autowired
	private TeacherRepositoryService teacherRepoService;
	
	@Autowired
	private CourseRepositoryService courseRepoService;
	
	@RequestMapping(value = "/{teacher_id}/create_course_form",method = RequestMethod.GET)
	public String CourseForm(Model model,@PathVariable String teacher_id,Course course){
		model.addAttribute("teacher",teacherRepoService.getTeacher(teacher_id));
		return "create_course_form";
	}
	
	@RequestMapping("/ShowCourses")
	public String ShowCourses(Model model){
//	    ModelAndView mav = new ModelAndView("ShowCourses");
	    List<Course> Courses = courseRepoService.ShowCourses();
//	    mav.addObject("Courses",Courses);
	    model.addAttribute("Courses", Courses);
	    return  "ShowCourses";
	}


	@RequestMapping(value = "/{teacher_id}/create_course_form", method = RequestMethod.POST)
	public String CreateCourse(@PathVariable String teacher_id,@Valid Course course, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors() ) {
			return "create_course_form";
		}
		else if(!Validate(course.getName())){
			model.addAttribute("Wrongname",true);
			return "create_course_form";
		}
		Teacher teacher = new Teacher();
		teacher.setUsername(teacher_id);
		course.setTeacher(teacher);
		
		courseRepoService.CreateCourse(course);
		model.addAttribute("Course", course);
		return "/result";
	}

	@RequestMapping(value = "/Course/{id}", method = RequestMethod.GET)
	public Course getCourse(@PathVariable String id) {
		return courseRepoService.getCourse(id);
	}
	
	public boolean Validate(String name) {
		
		if(courseRepoService.getCourse(name)!=null)
			return false;
		else
			return true;
	}
}
