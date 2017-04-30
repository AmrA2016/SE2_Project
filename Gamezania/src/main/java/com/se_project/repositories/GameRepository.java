/**
 * 
 */
package com.se_project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.se_project.models.Game;

/**
  * this class handles database operations for  games table (  games)

 *
 */
public interface GameRepository extends CrudRepository<Game,Long> {
	
        /**
	 * this function searches for a course by its id
	 * 
	 * @param cid
	 *            holds the course id
         *
	 * @return list of  games within this course
	 */
	public List<Game> findByCourseCid(long cid);
	
        /**
	 * this function searches for a course by its name
	 * 
	 * @param name
	 *            holds the course name
         *
	 * @return list of  games within this course
	 */
	public List<Game> findByName(String name);
}
