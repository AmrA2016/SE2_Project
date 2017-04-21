/**
 * 
 */
package com.se_project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.se_project.models.MCQGame;

/**
  * this class handles database operations for mcq_games table (MCQ games)

 *
 */
public interface MCQGameRepository extends CrudRepository<MCQGame,Long> {
        /**
	 * this function searches for a course by its id
	 * 
	 * @param cid
	 *            holds the course id
         *
	 * @return list of MCQ games within this course
	 */
	public List<MCQGame> findByCourseCid(long cid);
	
        /**
	 * this function searches for a course by its name
	 * 
	 * @param name
	 *            holds the course name
         *
	 * @return list of MCQ games within this course
	 */
	public List<MCQGame> findByName(String name);
}
