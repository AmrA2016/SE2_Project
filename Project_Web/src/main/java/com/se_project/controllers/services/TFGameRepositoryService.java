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
 * @author Amr
 *
 */
@Service
public class TFGameRepositoryService {
	
	@Autowired
	TFGameRepository tfGameRepo;
	
	public TFGame getGame(long gid){
		return tfGameRepo.findOne(gid);
	}
	
	public TFGame getGameInCourse (long cid,long gid){
		List<TFGame> games = tfGameRepo.findByCourseCid(cid);
		
		for(int i =0;i < games.size();i++)
			if(games.get(i).getGid() == gid)
				return games.get(i);
		return null;
	}
	
	public List<TFGame> getGamesByName(String name){
		return tfGameRepo.findByName(name);
	}
	
	public List<TFGame> getGameByCourseId(long courseId)
	{
		return tfGameRepo.findByCourseCid(courseId);
	}
	
	public TFGame getGameByCourseAndName (long cid, String name){
		List<TFGame> games = tfGameRepo.findByCourseCid(cid);
		
		for(int i =0;i < games.size();i++)
			if(games.get(i).getName().equals(name))
				return games.get(i);
		return null;
	}
	
	public void saveGame(TFGame game){
		tfGameRepo.save(game);
	}
}
