/**
 * 
 */
package com.se_project.controllers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se_project.models.Game;
import com.se_project.models.TFGame;
import com.se_project.repositories.GameRepository;

/**
 * The class implements the needed operations for handling the MCQ_Game repository 
 * as saving them in database or retrieving them
 */
@Service
public class GameRepositoryService {

	@Autowired
	GameRepository GameRepo;
	
	/**
	 * Get a  game from the database by id
	 * @param gid the id of the game to be retrieved
	 * @return  game object
	 */
	public Game getGame(long gid){
		return GameRepo.findOne(gid);
	}
	
	/**
	 * Get a  game by id in a certain course
	 * @param cid the id of the course contains this game
	 * @param gid the id of the game to to be retrieved
	 * @return
	 */
	public Game getGameInCourse (long cid,long gid){
		List<Game> games = GameRepo.findByCourseCid(cid);
		
		for(int i =0;i < games.size();i++)
			if(games.get(i).getGid() == gid)
				return games.get(i);
		return null;
	}
	
	/**
	 * Get list of all  games with a given name 
	 * <p>
	 * Note: the game name must be unique only in course but it's not unique over the courses
	 * @param name the name of the games to be retrieved
	 * @return list of  games
	 */
	public List<Game> getGamesByName(String name){
		return GameRepo.findByName(name);
	}
	
	/**
	 * Get list of all  games in a certain course
	 * @param courseId the id of the course that contains the games to be retrieved
	 * @return list of  games
	 */
	public List<Game> getGameByCourseId(long courseId)
	{
		return GameRepo.findByCourseCid(courseId);
	}
	
	/**
	 * Get a certain  game by name in a certain course
	 * @param cid the id of the course that contains the game to be retrieved
	 * @param name the game name to be retrieved
	 * @return  game
	 */
	public Game getGameByCourseAndName (long cid, String name){
		List<Game> games = GameRepo.findByCourseCid(cid);
		
		for(int i =0;i < games.size();i++)
			if(games.get(i).getName().equals(name))
				return games.get(i);
		return null;
	}
	
	/**
	 * Save  game object in the database
	 * @param game the  game to be stored
	 */
	public void saveGame(Game game){
		GameRepo.save(game);
	}
	

	/**
	 * Delete  game from database by id
	 * @param gid the id of the game to be deleted
	 */
	public void deleteGame(long gid){
		GameRepo.delete(gid);
	}
	
	/**
	 * Delete  game from database by object
	 * @param game the game object to be deleted
	 */
	public void deleteGame(Game game){
		GameRepo.delete(game);
	}
}
