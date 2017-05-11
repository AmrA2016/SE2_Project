/**
 * 
 */
package com.se_project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.se_project.models.MCQQuestion;

/**
 * this class handles database operations for mcq_questions table (MCQ questions)
 *
 */
public interface MCQQuestionRepository extends CrudRepository<MCQQuestion, Long> {
        /**
	 * this function searches for MCQ game by its id
	 * 
	 * @param gid
	 *            holds the game id
         *
	 * @return list of MCQ games
	 */
	public List<MCQQuestion> findByMcqgameGid (long gid);
}
