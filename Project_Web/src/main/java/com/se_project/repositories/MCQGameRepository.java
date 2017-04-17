/**
 * 
 */
package com.se_project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.se_project.models.MCQGame;

/**
 * @author Amr
 *
 */
public interface MCQGameRepository extends CrudRepository<MCQGame,Long> {
	public List<MCQGame> findByCourseCid(long cid);
	
	public List<MCQGame> findByName(String name);
}
