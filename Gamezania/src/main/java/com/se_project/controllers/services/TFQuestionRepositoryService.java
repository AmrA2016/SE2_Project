package com.se_project.controllers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se_project.models.TFQuestion;
import com.se_project.repositories.TFQuestionRepository;

/**
 * The class implements the needed operation for handling the TF_Question repository 
 * as saving them in database or retrieving them
 *
 */
@Service
public class TFQuestionRepositoryService {
	
	@Autowired
	TFQuestionRepository tfQuestionRepo;
	
	/**
	 * return list of all questions in certain T/F game
	 * @param gid the game_id that contains the questions
	 * @return list of T/F questions in a game
	 */
	public List<TFQuestion> getQuestionsOfGame(long gid){
		return tfQuestionRepo.findByTfgameGid(gid);
	}
	
	
	/**
	 * Save T/F question in the database
	 * @param question the question to be saved
	 */
	public void saveQuestion(TFQuestion question){
		tfQuestionRepo.save(question);
	}
	
}
