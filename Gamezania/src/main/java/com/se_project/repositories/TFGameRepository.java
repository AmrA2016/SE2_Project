/**
 * 
 */
package com.se_project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.se_project.models.TFGame;

/**
 * this class handles database operations for tfgames table ("True/False" games)
 *
 */
public interface TFGameRepository extends CrudRepository<TFGame,Long> {
        /**
	 * this function searches for a course by its id
	 * 
	 * @param cid
	 *            holds the course id
         *
	 * @return list of "true or false" games within this course
	 */
	public List<TFGame> findByCourseCid(long cid);
	
        /**
	 * this function searches for a course by its name
	 * 
	 * @param name
	 *            holds the course name
         *
	 * @return list of "true or false" games within this course
	 */
	public List<TFGame> findByName(String name);
}
