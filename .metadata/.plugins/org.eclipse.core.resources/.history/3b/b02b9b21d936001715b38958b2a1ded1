package com.se_project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.se_project.models.GameCollaborator;

public interface GameCollaboratorRepository extends CrudRepository<GameCollaborator,Long> {
	public List<GameCollaborator> findByTeacherUsername(String username);
}
