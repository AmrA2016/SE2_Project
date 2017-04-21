/**
 * 
 */
package com.se_project.controllers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se_project.models.MCQGame;
import com.se_project.models.TFGame;
import com.se_project.repositories.TFGameRepository;

/**
 * The class implements the needed operations for handling the TF_Game repository 
 * as saving them in database or retrieving them
 */
@Service
public class TFGameRepositoryService {
	
	@Autowired
	TFGameRepository tfGameRepo;
	
	/**
	 * Get a T/F game from the database by id
	 * @param gid the id of the game to be retrieved
	 * @return T/F game object
	 */
	public TFGame getGame(long gid){
		return tfGameRepo.findOne(gid);
	}
	
	/**
	 * Get a T/F game by id in a certain course
	 * @param cid the id of the course contains this game
	 * @param gid the id of the game to to be retrieved
	 * @return
	 */
	public TFGame getGameInCourse (long cid,long gid){
		List<TFGame> games = tfGameRepo.findByCourseCid(cid);
		
		for(int i =0;i < games.size();i++)
			if(games.get(i).getGid() == gid)
				return games.get(i);
		return null;
	}
	
	
	/**
	 * Get list of all T/F games with a given name 
	 * <p>
	 * Note: the game name must be unique only in course but it's not unique over the courses
	 * @param name the name of the games to be retrieved
	 * @return list of T/F games
	 */
	public List<TFGame> getGamesByName(String name){
		return tfGameRepo.findByName(name);
	}
	
	
	/**
	 * Get list of all T/F games in a certain course
	 * @param courseId the id of the course that contains the games to be retrieved
	 * @return list of T/F games
	 */
	public List<TFGame> getGameByCourseId(long courseId)
	{
		return tfGameRepo.findByCourseCid(courseId);
	}
	
	/**
	 * Get a certain T/F game by name in a certain course
	 * @param cid the id of the course that contains the game to be retrieved
	 * @param name the game name to be retrieved
	 * @return T/F game
	 */
	public TFGame getGameByCourseAndName (long cid, String name){
		List<TFGame> games = tfGameRepo.findByCourseCid(cid);
		
		for(int i =0;i < games.size();i++)
			if(games.get(i).getName().equals(name))
				return games.get(i);
		return null;
	}
	
	
	/**
	 * Save T/F game object in the database
	 * @param game the T/F game to be stored
	 */
	public void saveGame(TFGame game){
		tfGameRepo.save(game);
	}
	
	/**
	 * Delete T/F game from database
	 * @param gid the id of the game to be deleted
	 */
	public void deleteGame(long gid){
		tfGameRepo.delete(gid);
	}
}
