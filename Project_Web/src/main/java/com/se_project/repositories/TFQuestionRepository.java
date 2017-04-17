/**
 * 
 */
package com.se_project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.se_project.models.TFQuestion;

/**
 * @author Amr
 *
 */
public interface TFQuestionRepository extends CrudRepository<TFQuestion, Long> {
	public List<TFQuestion> findByTfgameGid (long gid);

}
