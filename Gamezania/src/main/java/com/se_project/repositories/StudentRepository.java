package com.se_project.repositories;

import org.springframework.data.repository.CrudRepository;

import com.se_project.models.Student;

/**
 * this class handles database operations for student table 
 *
 */

public interface StudentRepository extends CrudRepository<Student,String> {

}
