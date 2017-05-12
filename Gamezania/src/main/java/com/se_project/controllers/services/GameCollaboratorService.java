package com.se_project.controllers.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se_project.models.Game;
import com.se_project.models.GameCollaborator;
import com.se_project.models.Teacher;
import com.se_project.repositories.GameCollaboratorRepository;

@Service
public class GameCollaboratorService {
	
	@Autowired
	GameCollaboratorRepository gameCollaboratorRepo;
	
	@Autowired
	TeacherRepositoryService teacherRepoService;
	
	public void add_owner(long gid,String teacher_id){
		GameCollaborator gameCollaborator = new GameCollaborator();
		Teacher teacher = new Teacher(teacher_id);
		Game game = new Game(gid);
		
		gameCollaborator.setGame(game);
		gameCollaborator.setTeacher(teacher);
		gameCollaborator.setOwner(true);
		gameCollaborator.setAccepted(true);
		
		gameCollaboratorRepo.save(gameCollaborator);
	}
	
	public boolean inviteTeacher(long gid,String teacherId )
	{
		
		Teacher teacher = teacherRepoService.getTeacher(teacherId);
		GameCollaborator gameCollaborator = new GameCollaborator();
		boolean found = false;
		
		if(teacher != null)
		{
			Game game = new Game(gid);
			gameCollaborator.setGame(game);
			gameCollaborator.setTeacher(teacher);
			gameCollaborator.setOwner(false);
			gameCollaborator.setAccepted(false);
			gameCollaboratorRepo.save(gameCollaborator);
			found = true;
		}
		
		return found;
	}
	
	public List<GameCollaborator> getTeacherCollaborations(String username){
		List<GameCollaborator> gameCollaborators = gameCollaboratorRepo.findByTeacherUsername(username);
		return gameCollaborators;
	}
	
	public List<Game> getGamesByTeacherID(String username){
		List<GameCollaborator> gameCollaborators = gameCollaboratorRepo.findByTeacherUsername(username);
		List<Game> games = new ArrayList<Game>();
		
		for(int i =0;i < gameCollaborators.size();i++)
			games.add(gameCollaborators.get(i).getGame());
		
		return games;
	}
	
	public void accept(long collaboratorId){
		GameCollaborator gameCollaborator =  gameCollaboratorRepo.findOne(collaboratorId);
		gameCollaborator.setAccepted(true);
		gameCollaboratorRepo.save(gameCollaborator);
		
	}
	
	public void refuse(long collaboratorId){
		gameCollaboratorRepo.delete(collaboratorId);
	}
	
	
	
}
