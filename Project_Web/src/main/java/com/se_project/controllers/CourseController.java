package com.se_project.controllers;

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
import com.se_project.models.Course;

@Controller
public class CourseController {
	@Autowired
	private CourseRepositoryService courseRepoService;
	
	@RequestMapping(value = "/create_course_form",method = RequestMethod.GET)
	public String CourseForm(Course course){
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


	@RequestMapping(value = "/create_course_form", method = RequestMethod.POST)
	public String CreateCourse(@Valid Course course, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors() ) {
			return "create_course_form";
		}
		else if(!Validate(course.getName())){
			model.addAttribute("Wrongname",true);
			return "create_course_form";
		}
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
