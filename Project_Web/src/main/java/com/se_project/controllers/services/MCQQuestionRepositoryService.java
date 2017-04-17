package com.se_project.controllers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se_project.repositories.MCQQuestionRepository;
import com.se_project.models.MCQQuestion;


@Service
public class MCQQuestionRepositoryService {
	
	@Autowired
	MCQQuestionRepository mcqQuestionRepo;
	
	public List<MCQQuestion> getQuestionsOfGame(long gid){
		return mcqQuestionRepo.findByMcqgameGid(gid);
	}
	
	public void saveQuestion(MCQQuestion question){
		mcqQuestionRepo.save(question);
	}
	
}
