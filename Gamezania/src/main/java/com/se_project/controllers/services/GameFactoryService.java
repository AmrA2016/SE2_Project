package com.se_project.controllers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se_project.models.Course;
import com.se_project.models.Game;
import com.se_project.models.MCQGame;
import com.se_project.models.MCQQuestion;
import com.se_project.models.TFGame;
import com.se_project.models.TFQuestion;

@Service
public class GameFactoryService {
	
	@Autowired
	GameRepositoryService gameRepoService;

	@Autowired
	TFQuestionRepositoryService tfQuestionRepoService;

	@Autowired
	MCQQuestionRepositoryService mcqQuestionRepoService;
	
	public void saveCopyOfGame(long gameId, long cid){
		
		Game game = new Game(gameRepoService.getGame(gameId));
		game.setCourse(new Course(cid));
		gameRepoService.saveGame(game);
		
		String type = game.getGame_type();
		
		if(type.equals("MCQ")){
			
			List<MCQQuestion> mcqQuestionsList = mcqQuestionRepoService.getQuestionsOfGame(gameId);
			for(int i =0; i < mcqQuestionsList.size();i++){
				MCQQuestion question = new MCQQuestion(mcqQuestionsList.get(i));
				question.setMcqgame(game);
				mcqQuestionRepoService.saveQuestion(question);
			}
		}
		else if(type.equals("TF")){
			List<TFQuestion> tfQuestionsList = tfQuestionRepoService.getQuestionsOfGame(gameId);
			for(int i =0; i < tfQuestionsList.size();i++){
				TFQuestion question = new TFQuestion(tfQuestionsList.get(i));
				question.setTfgame(game);
				tfQuestionRepoService.saveQuestion(question);
			}
		}
		
	}
	
	public Game getCopyOfGame(long gameId,String type){
		
		Game temp = gameRepoService.getGame(gameId);
		
		if(type.equals("MCQ")){
			MCQGame mcqGame = new MCQGame(temp);
			
			List<MCQQuestion> mcqQuestionsList = mcqQuestionRepoService.getQuestionsOfGame(gameId);
			MCQQuestion[] mcqquestions = new MCQQuestion[5];
			for(int i =0;i < 5;i++){
				if(i < mcqQuestionsList.size())
					mcqquestions[i] = mcqQuestionsList.get(i);
				else
					mcqquestions[i] = new MCQQuestion();
			}
			
			mcqGame.setMcqquestions(mcqquestions);
			mcqGame.setNumberOfQuestions(mcqQuestionsList.size());
			return mcqGame;
		}
		else if(type.equals("TF")){
			TFGame tfGame = new TFGame(temp);
			
			List<TFQuestion> tfQuestionsList = tfQuestionRepoService.getQuestionsOfGame(gameId);
			TFQuestion[] tfquestions = new TFQuestion[5];
			for(int i =0;i < 5;i++){
				if(i < tfQuestionsList.size())
					tfquestions[i] = tfQuestionsList.get(i);
				else
					tfquestions[i] = new TFQuestion();
			}
			
			tfGame.setTfquestions(tfquestions);
			tfGame.setNumberOfQuestions(tfQuestionsList.size());
			return tfGame;
		}
		else
			return temp;
		
	}
	

}
