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
 * @author Amr
 *
 */
@Service
public class MCQGameRepositoryService {

	@Autowired
	MCQGameRepository mcqGameRepo;
	
	public MCQGame getGame(long gid){
		return mcqGameRepo.findOne(gid);
	}
	
	public MCQGame getGameInCourse (long cid,long gid){
		List<MCQGame> games = mcqGameRepo.findByCourseCid(cid);
		
		for(int i =0;i < games.size();i++)
			if(games.get(i).getGid() == gid)
				return games.get(i);
		return null;
	}
	
	public List<MCQGame> getGamesByName(String name){
		return mcqGameRepo.findByName(name);
	}
	public List<MCQGame> getGameByCourseId(long courseId)
	{
		return mcqGameRepo.findByCourseCid(courseId);
	}
	public MCQGame getGameByCourseAndName (long cid, String name){
		List<MCQGame> games = mcqGameRepo.findByCourseCid(cid);
		
		for(int i =0;i < games.size();i++)
			if(games.get(i).getName().equals(name))
				return games.get(i);
		return null;
	}
	
	public void saveGame(MCQGame game){
		mcqGameRepo.save(game);
	}
}
