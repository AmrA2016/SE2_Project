package com.se_project.controllers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se_project.models.TFQuestion;
import com.se_project.repositories.TFQuestionRepository;

@Service
public class TFQuestionRepositoryService {
	
	@Autowired
	TFQuestionRepository tfQuestionRepo;
	
	public List<TFQuestion> getQuestionsOfGame(long gid){
		return tfQuestionRepo.findByTfgameGid(gid);
	}
	
	public void saveQuestion(TFQuestion question){
		tfQuestionRepo.save(question);
	}
	
}
