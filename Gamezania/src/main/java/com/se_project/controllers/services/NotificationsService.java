package com.se_project.controllers.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se_project.models.StudentNotification;
import com.se_project.repositories.CourseRepository;
import com.se_project.repositories.StudentNotificationsRepo;

@Service
public class NotificationsService {
    
	@Autowired
	private StudentNotificationsRepo studentNotificationrepo;
	
	
	
	public List<StudentNotification> getStudentNotification(String username){
		List<StudentNotification>notification =new ArrayList<StudentNotification>();
		studentNotificationrepo.findByStudentUsername(username).forEach(notification::add);
		return notification;
	}
	
	
	public void createStudentNotification(StudentNotification studentNotification)
	{
		studentNotificationrepo.save(studentNotification);
	}
	
}
