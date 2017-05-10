package com.se_project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.se_project.models.StudentNotification;

public interface StudentNotificationsRepo extends CrudRepository<StudentNotification,String> {

	List<StudentNotification> findByStudentUsername(String username);
}
