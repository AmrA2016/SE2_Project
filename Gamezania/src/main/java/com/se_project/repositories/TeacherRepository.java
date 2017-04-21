package com.se_project.repositories;

import org.springframework.data.repository.CrudRepository;

import com.se_project.models.Teacher;

/**
 * this class handles database operations for teacher table 
 *
 */
public interface TeacherRepository extends CrudRepository<Teacher, String> {

}
