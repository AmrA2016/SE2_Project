/**
 * 
 */
package com.se_project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.se_project.models.TFQuestion;

/**
 * this class handle database operations for tfquestions  table ("True/False" questions) 
 *
 */
public interface TFQuestionRepository extends CrudRepository<TFQuestion, Long> {
        /**
	 * this function searches for a "true or false" game by its id
	 * 
	 * @param gid
	 *            holds the game id
         *
	 * @return list of "true or false" games
	 */
	public List<TFQuestion> findByTfgameGid (long gid);

}
