/**
 * 
 */
package com.se_project.controllers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se_project.models.MCQGame;
import com.se_project.models.TFGame;
import com.se_project.repositories.MCQGameRepository;

/**
 * The class implements the needed operations for handling the MCQ_Game repository 
 * as saving them in database or retrieving them
 */
@Service
public class MCQGameRepositoryService {

	@Autowired
	MCQGameRepository mcqGameRepo;
	
	/**
	 * Get a MCQ game from the database by id
	 * @param gid the id of the game to be retrieved
	 * @return MCQ game object
	 */
	public MCQGame getGame(long gid){
		return mcqGameRepo.findOne(gid);
	}
	
	/**
	 * Get a MCQ game by id in a certain course
	 * @param cid the id of the course contains this game
	 * @param gid the id of the game to to be retrieved
	 * @return
	 */
	public MCQGame getGameInCourse (long cid,long gid){
		List<MCQGame> games = mcqGameRepo.findByCourseCid(cid);
		
		for(int i =0;i < games.size();i++)
			if(games.get(i).getGid() == gid)
				return games.get(i);
		return null;
	}
	
	/**
	 * Get list of all MCQ games with a given name 
	 * <p>
	 * Note: the game name must be unique only in course but it's not unique over the courses
	 * @param name the name of the games to be retrieved
	 * @return list of MCQ games
	 */
	public List<MCQGame> getGamesByName(String name){
		return mcqGameRepo.findByName(name);
	}
	
	/**
	 * Get list of all MCQ games in a certain course
	 * @param courseId the id of the course that contains the games to be retrieved
	 * @return list of MCQ games
	 */
	public List<MCQGame> getGameByCourseId(long courseId)
	{
		return mcqGameRepo.findByCourseCid(courseId);
	}
	
	/**
	 * Get a certain MCQ game by name in a certain course
	 * @param cid the id of the course that contains the game to be retrieved
	 * @param name the game name to be retrieved
	 * @return MCQ game
	 */
	public MCQGame getGameByCourseAndName (long cid, String name){
		List<MCQGame> games = mcqGameRepo.findByCourseCid(cid);
		
		for(int i =0;i < games.size();i++)
			if(games.get(i).getName().equals(name))
				return games.get(i);
		return null;
	}
	
	/**
	 * Save MCQ game object in the database
	 * @param game the MCQ game to be stored
	 */
	public void saveGame(MCQGame game){
		mcqGameRepo.save(game);
	}
}
