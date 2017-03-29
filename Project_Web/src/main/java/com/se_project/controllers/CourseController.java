package com.se_project.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.se_project.controllers.services.CourseRepositoryService;
import com.se_project.models.Course;

@Controller
public class CourseController {
	@Autowired
	private CourseRepositoryService courseservice;

	@RequestMapping(value = "/ShowCourses", method = RequestMethod.GET)
	public List<Course> ShowCourses() {
		return courseservice.ShowCourses();
	}

	@RequestMapping(value = "/CreateCourseForm", method = RequestMethod.GET)
	public String CreateCourseForm() {
		return "create_course_form";
	}

	@RequestMapping(value = "/CreateCourseForm", method = RequestMethod.POST)
	public String CreateCourse(@Valid Course course, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors() || 
		 courseservice.ValidateName(course.getName()) != true) {
			return "create_course_form";
		}

		model.addAttribute("name", course.getName());
		model.addAttribute("description", course.getDescription());
		model.addAttribute("age", course.getAgeRestriction());
		model.addAttribute("category", course.getCategory());
		model.addAttribute("image", course.getImage());
		return "result";

	}

	@RequestMapping(value = "/Course/{id}", method = RequestMethod.GET)
	public Course getCourse(@PathVariable String id) {
		return courseservice.getCourse(id);
	}
}
