package com.se_project.repositories;

import org.springframework.data.repository.CrudRepository;

import com.se_project.models.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, String> {

}
