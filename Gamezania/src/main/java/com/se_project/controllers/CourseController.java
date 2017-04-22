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
import com.se_project.controllers.services.StudentRepositoryService;
import com.se_project.controllers.services.TFGameRepositoryService;
import com.se_project.controllers.services.TeacherRepositoryService;
import com.se_project.models.Course;
import com.se_project.models.Game;
import com.se_project.models.MCQGame;
import com.se_project.models.TFGame;
import com.se_project.models.Teacher;

/**
 * This class implements the controller functions that link between the course model
 * and its views.
 *
 */
@Controller
public class CourseController {

	@Autowired
	private TeacherRepositoryService teacherRepoService;

	@Autowired
	StudentRepositoryService studentRepoService;

	@Autowired
	private CourseRepositoryService courseRepoService;

	@Autowired
	private TFGameRepositoryService tfGameRepoService;

	@Autowired
	private MCQGameRepositoryService mcqGameRepoService;

	@Autowired
	private ImageService imageService;

	/**
	 * this function takes teacher id and returns HTML page of the course form
	 * that is used in creating new course by this teacher
	 * 
	 * @param model
	 *            used to add teacher_id to HTML element
	 * @param teacher_id
	 *            used to identify the teacher over the system
	 * @param course
	 *            object of the course that is created by the teacher
	 * @return HTML page that shows course form
	 */
	@RequestMapping(value = "/{teacher_id}/create_course_form", method = RequestMethod.GET)
	public String CourseForm(Model model, @PathVariable String teacher_id, Course course) {
		if(!UserController.current_user.equals(teacher_id))
			return "redirect:/";
		model.addAttribute("teacher_id", teacher_id);
		return "Teacher/createCourse";
	}


	/**
	 * this function returns HTML page of the courses of a specific teacher that
	 * is created by him
	 * 
	 * @param teacher_id
	 *            identifing the teacher through the system
	 * @param model
	 *            used to add the courses attributes and the id of a specific
	 *            teacher to HTML elements in a HTML page
	 * @return HTML page of teacher's courses
	 */
	@RequestMapping(value = "/{teacher_id}/ShowMyCourses", method = RequestMethod.GET)
	public String ShowMyCourses(@PathVariable String teacher_id, Model model) {
		if(!UserController.current_user.equals(teacher_id))
			return "redirect:/";
		List<Course> Courses = courseRepoService.getCoursesByTeacher(teacher_id);
		model.addAttribute("Courses", Courses);
		model.addAttribute("teacher_id", teacher_id);
		return "Teacher/myCourses";
	}

	/**
	 * this function takes a course data from a teacher and creates it
	 * 
	 * @param imagefile
	 *            holds the path of the image of the course added by a teacher
	 *            (is chosen by the teacher)
	 * @param teacher_id
	 *            identifing the teacher through the system
	 * @param course
	 *            object of the course that is created by a specific teacher
	 * @param bindingResult
	 *            checks if the user input has errors
	 * @param model
	 *            used to add the course attributes to HTML elements
	 * @return HTML page of the course if the course creation is successful or HTML page of the create Course form if the data entered is     wrong
	 */
	@RequestMapping(value = "/{teacher_id}/create_course_form", method = RequestMethod.POST)
	public String CreateCourse(@RequestParam("imagefile") MultipartFile imagefile, @PathVariable String teacher_id,
			@Valid Course course, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "Teacher/createCourse";
		} else if (!Validate(course.getName())) {
			model.addAttribute("Wrongname", true);
			return "Teacher/createCourse";
		} else if (imagefile.isEmpty()) {
			model.addAttribute("image_empty", true);
			return "Teacher/createCourse";
		}
		Teacher teacher = new Teacher();
		teacher.setUsername(teacher_id);
		course.setTeacher(teacher);

		course.setImage(imageService.storeImage(imagefile));

		courseRepoService.CreateCourse(course);
		model.addAttribute("Course", course);
		model.addAttribute("teacher_id", teacher_id);
		return "Teacher/myCoursePage";
	}

	/**
	 * this function shows the courses by category, every category has courses
	 * so it shows the courses of the chosen category by a user (teacher or
	 * student), it also shows all the courses if the user choose "All
	 * Categories" option
	 * 
	 * @param category
	 *            holds the category name that is unique through the system
	 * @param user_id
	 *            holds the user id that identifies the user through the system
	 * @param model
	 *            add the course attributes to HTML elements of the HTML page of
	 *            the user home-page, and the user id
	 * @return HTML page of a user (teacher or student) home-page
	 */
	@RequestMapping("/user/{user_id}/{category}")
	public String showCoursesByCategory(@PathVariable String category, @PathVariable String user_id, Model model) {
		if(!UserController.current_user.equals(user_id))
			return "redirect:/";
		
		if (category.equals("All_Categories")) {
			return "redirect:/user/"+user_id;
		} else {
			List<Course> courses = courseRepoService.getCoursesByCategory(category);

			model.addAttribute("Student", studentRepoService.getStudent(user_id));
			model.addAttribute("courses", courses);

			return "Student/S_Homepage";
		}

	}

	/**
	 * this function get all the games of a specific course and show it in the course page
	 * 
	 * @param user_id
	 *            identifies user through the system
	 * @param id
	 *            identifies course through the system
	 * @param model
	 *            add the course attributes and the games attributes to a HTML
	 *            page
	 * @return HTML page of a specific course to a teacher or to the student
         * the first if condition returns the page of a course owned by specefic teacher and the second 
         * one returns the page course to a student
	 */
	@RequestMapping("/{user_id}/Course/{id}")
	public String getCourse(@PathVariable String user_id, @PathVariable long id, Model model) {
		if(!UserController.current_user.equals(user_id))
			return "redirect:/";
		
		List<Course> courses = courseRepoService.getCoursesByTeacher(user_id);
		List<Game> games = new ArrayList<Game>();
		List<MCQGame> gameMCQ = mcqGameRepoService.getGameByCourseId(id);
		List<TFGame> gameTF = tfGameRepoService.getGameByCourseId(id);
		for (int i = 0; i < gameMCQ.size(); i++) {
			games.add(gameMCQ.get(i));
		}
		for (int i = 0; i < gameTF.size(); i++) {
			games.add(gameTF.get(i));
		}
		Collections.sort(games);
		model.addAttribute("Games", games);
		boolean myCourse = false;

		for (int i = 0; i < courses.size(); i++)
			if (courses.get(i).getCid() == id)
				myCourse = true;

		if (myCourse) {
			model.addAttribute("teacher_id", user_id);
			model.addAttribute("course", courseRepoService.getCourse(id));
			return "Teacher/myCoursePage";
		} else if (teacherRepoService.getTeacher(user_id) != null) {
			model.addAttribute("user_id", user_id);
			model.addAttribute("course", courseRepoService.getCourse(id));
			model.addAttribute("t_user", true);
			return "GlobalItems/coursePage";
		} else {
			model.addAttribute("user_id", user_id);
			model.addAttribute("course", courseRepoService.getCourse(id));
			return "GlobalItems/coursePage";
		}
	}

	/**
	 * this function delete a specific course
	 * 
	 * @param teacher_id
	 *            identifies a teacher through the system
	 * @param cid
	 *            identifies a course through the system
	 * @param model
	 * @return HTML page of the teacher courses
	 */
	@RequestMapping("/{teacher_id}/DeleteCourse/{cid}")
	public String deleteCourse(@PathVariable String teacher_id, @PathVariable long cid, Model model) {
		if(!UserController.current_user.equals(teacher_id))
			return "redirect:/";
		
		courseRepoService.deleteCourse(cid);
		return "redirect:/" + teacher_id + "/ShowMyCourses";
	}

	/**
	 * this function validates the course name in the form input while creating
	 * a course if is set with a value or not
	 * 
	 * @param course_name
	 *            holds the course name
	 * @return boolean true if the course name has value and false if it is
	 *         empty
	 */
	public boolean Validate(String course_name) {

		if (courseRepoService.getCourseByName(course_name) != null)
			return false;
		else
			return true;
	}
}
