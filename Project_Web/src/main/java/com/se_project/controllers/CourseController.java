package com.se_project.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.se_project.controllers.services.CourseRepositoryService;
import com.se_project.controllers.services.ImageService;
import com.se_project.controllers.services.MCQGameRepositoryService;
import com.se_project.controllers.services.TFGameRepositoryService;
import com.se_project.controllers.services.TeacherRepositoryService;
import com.se_project.models.Course;
import com.se_project.models.Game;
import com.se_project.models.MCQGame;
import com.se_project.models.TFGame;
import com.se_project.models.Teacher;

@Controller
public class CourseController {
	
	@Autowired
	private TeacherRepositoryService teacherRepoService;
	
	@Autowired
	private CourseRepositoryService courseRepoService;
	
	@Autowired
	private TFGameRepositoryService tfGameRepoService;
	
	@Autowired
	private MCQGameRepositoryService mcqGameRepoService;
	
	@Autowired
	private ImageService imageService;
	
	@RequestMapping(value = "/{teacher_id}/create_course_form",method = RequestMethod.GET)
	public String CourseForm(Model model,@PathVariable String teacher_id,Course course){
		model.addAttribute("teacher_id",teacher_id);
		return "Teacher/createCourse";
	}
	
	@RequestMapping("/ShowCourses")
	public String ShowCourses(Model model){
	    List<Course> Courses = courseRepoService.getAllCourses();
	    model.addAttribute("Courses", Courses);
	    return  "Teacher/myCourses";
	}
	
	@RequestMapping(value = "/{teacher_id}/ShowMyCourses", method = RequestMethod.GET)
	public String ShowMyCourses(@PathVariable String teacher_id, Model model){
	    List<Course> Courses = courseRepoService.getCoursesByTeacher(teacher_id);
	    model.addAttribute("Courses", Courses);
		model.addAttribute("teacher_id",teacher_id);
	    return  "Teacher/myCourses";
	}
	
	@RequestMapping(value = "/{teacher_id}/create_course_form", method = RequestMethod.POST)
	public String CreateCourse(@RequestParam("imagefile") MultipartFile imagefile,@PathVariable String teacher_id,@Valid Course course,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors() ) {
			return "Teacher/createCourse";
		}
		else if(!Validate(course.getName())){
			model.addAttribute("Wrongname",true);
			return "Teacher/createCourse";
		}
		else if(imagefile.isEmpty()){
			model.addAttribute("image_empty",true);
			return "Teacher/createCourse";
		}
		Teacher teacher = new Teacher();
		teacher.setUsername(teacher_id);
		course.setTeacher(teacher);
		
		imageService.storeImage(imagefile);
		course.setImage(imagefile.getOriginalFilename());
		
		courseRepoService.CreateCourse(course);
		model.addAttribute("Course", course);
		model.addAttribute("teacher_id",teacher_id);
		return "Teacher/myCoursePage";
	}

	@RequestMapping("/{user_id}/Course/{id}")
	public String getTeacherCourse(@PathVariable String user_id,@PathVariable long id, Model model) {
		List<Course> courses = courseRepoService.getCoursesByTeacher(user_id);
		List<Game> games = new ArrayList<Game>();
		List<MCQGame> gameMCQ = mcqGameRepoService.getGameByCourseId(id);
		List<TFGame> gameTF = tfGameRepoService.getGameByCourseId(id);
		for(int i = 0 ; i < gameMCQ.size(); i++)
		{
			games.add(gameMCQ.get(i));
		}
		for(int i = 0 ; i < gameTF.size(); i++)
		{
			games.add(gameTF.get(i));
		}
		Collections.sort(games);
		model.addAttribute("Games", games);
		if(courses.size() > 0){
			model.addAttribute("teacher_id", user_id);
			model.addAttribute("course",courseRepoService.getCourse(id));
			return "Teacher/myCoursePage";
		}
		else if(teacherRepoService.getTeacher(user_id) != null){
			model.addAttribute("user_id",user_id);
			model.addAttribute("course",courseRepoService.getCourse(id));
			model.addAttribute("t_user",true);
			return "GlobalItems/coursePage";
		}
		else{
			model.addAttribute("user_id",user_id);
			model.addAttribute("course",courseRepoService.getCourse(id));
			return "GlobalItems/coursePage";
		}
	}
	
	@RequestMapping("/{teacher_id}/DeleteCourse/{cid}")
	public String deleteCourse(@PathVariable String teacher_id,
			@PathVariable long cid, Model model){
		
		courseRepoService.deleteCourse(cid);
		List<Course> Courses = courseRepoService.getCoursesByTeacher(teacher_id);
	    model.addAttribute("Courses", Courses);
		model.addAttribute("teacher_id",teacher_id);
	    return  "Teacher/myCourses";
	}
	
	public boolean Validate(String course_name) {
		
		if(courseRepoService.getCourseByName(course_name)!=null)
			return false;
		else
			return true;
	}
}
