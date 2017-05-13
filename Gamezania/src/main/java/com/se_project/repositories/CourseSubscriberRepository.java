package com.se_project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.se_project.models.CourseSubscriber;

public interface CourseSubscriberRepository extends CrudRepository<CourseSubscriber,Long> {

	public List<CourseSubscriber> findByStudentUsername (String name);
	public List<CourseSubscriber> findByCourseCid (long cid);
	
	
}