package com.se_project.controllers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se_project.repositories.MCQQuestionRepository;
import com.se_project.models.MCQQuestion;

/**
 * The class implements the needed operation for handling the MCQ_Question repository 
 * as saving them in database or retrieving them
 *
 */
@Service
public class MCQQuestionRepositoryService {
	
	@Autowired
	MCQQuestionRepository mcqQuestionRepo;
	
	/**
	 * return list of all questions in certain MCQ game
	 * @param gid the game_id that contains the questions
	 * @return list of MCQ questions in a game
	 */
	public List<MCQQuestion> getQuestionsOfGame(long gid){
		return mcqQuestionRepo.findByMcqgameGid(gid);
	}
	
	/**
	 * Save MCQ question in the database
	 * @param question the question to be saved
	 */
	public void saveQuestion(MCQQuestion question){
		mcqQuestionRepo.save(question);
	}
	
}
