package com.se_project.controllers.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.se_project.models.Course;
import com.se_project.models.CourseSubscriber;
import com.se_project.models.Student;
import com.se_project.models.StudentNotification;
import com.se_project.repositories.CourseSubscriberRepository;

@Service
public class CourseSubscriberService {
	@Autowired
	private CourseSubscriberRepository courseSubRepo;
	@Autowired
	private NotificationsService notificationService;

	public void Subscribe(long cid, String user_id) {

		List<CourseSubscriber> courseSubscribers = courseSubRepo.findByCourseCid(cid);
		Student student = new Student();
		Course course = new Course();
		boolean found = false;
		CourseSubscriber courseSubscriber = new CourseSubscriber();
		for (int i = 0; i < courseSubscribers.size(); i++) {
			if ((user_id.equals(courseSubscribers.get(i).getStudent().getUsername()))) {
				found = true;
			}
		}
		
		if (found == false) {

			student.setUsername(user_id);
			course.setCid(cid);
			courseSubscriber.setStudent(student);
			courseSubscriber.setCourse(course);
			courseSubRepo.save(courseSubscriber);
		}
		
	}

	public List<CourseSubscriber> getSubscribers(long courseID) {
		List<CourseSubscriber> subscribers = new ArrayList<CourseSubscriber>();
		courseSubRepo.findAll().forEach(subscribers::add);
		return subscribers;
	}

	public void Notify(long cid, String courseName) {

		List<CourseSubscriber> subscribers = courseSubRepo.findByCourseCid(cid);

		for (int i = 0; i < subscribers.size(); i++) {
			StudentNotification notification = new StudentNotification();
			notification.setStudent(subscribers.get(i).getStudent());
			notification.setMsg("A new game has been added to course " + courseName);
			notificationService.createStudentNotification(notification);

		}

	}
}
