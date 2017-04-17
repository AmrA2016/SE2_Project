/**
 * 
 */
package com.se_project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.se_project.models.TFGame;

/**
 * @author Amr
 *
 */
public interface TFGameRepository extends CrudRepository<TFGame,Long> {
	public List<TFGame> findByCourseCid(long cid);
	
	public List<TFGame> findByName(String name);
}
