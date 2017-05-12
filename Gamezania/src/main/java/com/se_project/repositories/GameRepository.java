/**
 * 
 */
package com.se_project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.se_project.models.Game;

/**
 * this class handles database operations for games table ( games)
 *
 * 
 */
public interface GameRepository extends CrudRepository<Game, Long> {

	/**
	 * this function searches for a game by its course id
	 * 
	 * @param cid
	 *            holds the course id
	 *
	 * @return list of games within this course
	 */
	public List<Game> findByCourseCid(long cid);

	/**
	 * this function searches for games by their name
	 * 
	 * @param name
	 *            holds the game name
	 *
	 * @return list of games
	 */
	public List<Game> findByName(String name);
	
	/**
	 * this function searches for games starting with certain characters
	 * 
	 * @param query
	 *            the name to search for
	 *
	 * @return list of games
	 */
	public List<Game> findByNameStartingWith(String query);

	/**
	 * this function searches for games by deleted attribute
	 * 
	 * @param name
	 *            holds the game name
	 *
	 * @return list of all deleted or undeleted games
	 */
	public List<Game> findByDeleted(boolean flag);

}
