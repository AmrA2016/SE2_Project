/**
 * 
 */
package com.se_project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.se_project.models.MCQQuestion;

/**
 * @author Amr
 *
 */
public interface MCQQuestionRepository extends CrudRepository<MCQQuestion, Long> {
	public List<MCQQuestion> findByMcqgameGid (long gid);
}
