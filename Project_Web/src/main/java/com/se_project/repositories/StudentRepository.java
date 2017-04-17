package com.se_project.repositories;

import org.springframework.data.repository.CrudRepository;

import com.se_project.models.Student;

public interface StudentRepository extends CrudRepository<Student,String> {

}
