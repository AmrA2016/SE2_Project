package com.se_project.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.se_project.controllers.services.CourseRepositoryService;
import com.se_project.controllers.services.ImageService;
import com.se_project.controllers.services.MCQGameRepositoryService;
import com.se_project.controllers.services.MCQQuestionRepositoryService;
import com.se_project.controllers.services.TFGameRepositoryService;
import com.se_project.controllers.services.TFQuestionRepositoryService;
import com.se_project.controllers.services.TeacherRepositoryService;
import com.se_project.models.Answers;
import com.se_project.models.Game;
import com.se_project.models.MCQGame;
import com.se_project.models.MCQQuestion;
import com.se_project.models.TFGame;
import com.se_project.models.TFQuestion;

@Controller
public class GameController {
	@Autowired
	TFGameRepositoryService tfGameRepoService;
	
	@Autowired
	MCQGameRepositoryService mcqGameRepoService;
	
	@Autowired
	TFQuestionRepositoryService tfQuestionRepoService;
	
	@Autowired
	MCQQuestionRepositoryService mcqQuestionRepoService;
	
	@Autowired
	CourseRepositoryService courseRepoService;

	@Autowired
	TeacherRepositoryService teacherRepoService;
	
	@Autowired
	ImageService imageService;
	
	@RequestMapping(value = "/{teacher_id}/Course/{cid}/createMCQGame",method = RequestMethod.GET)
	public String CreateMCQGameForm(Model model,@ModelAttribute("mcqGame") MCQGame mcqGame, @PathVariable String teacher_id, @PathVariable long cid){
		model.addAttribute("teacher_id",teacher_id);
		model.addAttribute("cid",cid);
		
		return "Teacher/createMCQGame";
	}
	
	@RequestMapping(value = "/{teacher_id}/Course/{cid}/createTfGame",method = RequestMethod.GET)
	public String CreateTFGameForm(Model model, @ModelAttribute("tfGame") TFGame tfGame, @PathVariable String teacher_id, @PathVariable long cid){
		model.addAttribute("teacher_id",teacher_id);
		model.addAttribute("cid",cid);
		return "Teacher/createTfGame";
	}
	
	
	@RequestMapping(value = "/{teacher_id}/Course/{cid}/createMCQGame", method = RequestMethod.POST)
	public String CreateMCQGame(@Valid @ModelAttribute("mcqGame")  MCQGame mcqGame, BindingResult bindingResult, Model model, 
			@PathVariable String teacher_id, @PathVariable long cid,  @RequestParam("imagefile") MultipartFile imagefile) {
		
		if (bindingResult.hasErrors() ) {
			return "Teacher/createMCQGame";
		}
		else if(!Validate(cid,mcqGame.getName())){
			model.addAttribute("Wrongname",true);
			return "Teacher/createMCQGame";
		}
		else if(imagefile.isEmpty()){
			model.addAttribute("image_empty",true);
			return "Teacher/createMCQGame";
		}
		
		mcqGame.setCourse(courseRepoService.getCourse(cid));
		
		mcqGame.setImage(imageService.storeImage(imagefile));
		
		mcqGameRepoService.saveGame(mcqGame);
		
		for(int i =0;i < mcqGame.getNumberOfQuestions();i++){
			MCQQuestion question = new MCQQuestion();
			question.setQuestion(mcqGame.getQuestions()[i]);
			String[] choices = mcqGame.getChoices()[i];
			String correctIndex = mcqGame.getCorrectAnswers()[i];
			question.setCorrectAnswer(choices[Integer.parseInt(correctIndex)] );
			question.setChoice1(choices[0]);
			question.setChoice2(choices[1]);
			question.setChoice3(choices[2]);
			question.setChoice4(choices[3]);
			question.setMcqGame(mcqGame);
			mcqQuestionRepoService.saveQuestion(question);
		}
		
		List<Game> games = new ArrayList<Game>();
		List<MCQGame> gameMCQ = mcqGameRepoService.getGameByCourseId(cid);
		List<TFGame> gameTF = tfGameRepoService.getGameByCourseId(cid);
		for(int i = 0 ; i < gameMCQ.size(); i++)
		{
			games.add(gameMCQ.get(i));
		}
		for(int i = 0 ; i < gameTF.size(); i++)
		{
			games.add(gameTF.get(i));
		}
		Collections.sort(games);
		model.addAttribute("Games", games);
		
		model.addAttribute("teacher_id", teacher_id);
		model.addAttribute("course",courseRepoService.getCourse(cid));
		
	
		return "Teacher/myCoursePage";
	
	}


	@RequestMapping(value = "/{teacher_id}/Course/{cid}/createTfGame", method =RequestMethod.POST)
	public String CreateTOrFGame(@Valid @ModelAttribute("tfGame") TFGame tfGame, BindingResult bindingResult, Model model,
			@PathVariable String teacher_id, @PathVariable long cid, @RequestParam("imagefile") MultipartFile imagefile) {

		if (bindingResult.hasErrors() ) {
			return "Teacher/createTfGame";
		}
		else if(!Validate(cid,tfGame.getName())){
			model.addAttribute("Wrongname",true);
			return "Teacher/createTfGame";
		}
		else if(imagefile.isEmpty()){
			model.addAttribute("image_empty",true);
			return "Teacher/createTfGame";
		}

		tfGame.setCourse(courseRepoService.getCourse(cid));
		
		tfGame.setImage(imageService.storeImage(imagefile));
		
		tfGameRepoService.saveGame(tfGame);
		
		for(int i =0;i < tfGame.getNumberOfQuestions();i++){
			TFQuestion question = new TFQuestion();
			question.setQuestion(tfGame.getQuestions()[i]);
			question.setCorrectAnswer(tfGame.getCorrectAnswers()[i]);
			question.setTfGame(tfGame);
			tfQuestionRepoService.saveQuestion(question);
		}
		
		List<Game> games = new ArrayList<Game>();
		List<MCQGame> gameMCQ = mcqGameRepoService.getGameByCourseId(cid);
		List<TFGame> gameTF = tfGameRepoService.getGameByCourseId(cid);
		for(int i = 0 ; i < gameMCQ.size(); i++)
		{
			games.add(gameMCQ.get(i));
		}
		for(int i = 0 ; i < gameTF.size(); i++)
		{
			games.add(gameTF.get(i));
		}
		Collections.sort(games);
		model.addAttribute("Games", games);
		
		model.addAttribute("teacher_id", teacher_id);
		model.addAttribute("course",courseRepoService.getCourse(cid));
		
		return "Teacher/myCoursePage";
	
	}

	@RequestMapping(value = "/{user_id}/Course/{cid}/Game/{gid}",method = RequestMethod.GET)
	public String getGame(@ModelAttribute("answers") Answers user_answers, Model model, @PathVariable String user_id, 
			@PathVariable long cid, @PathVariable long gid){
		
		MCQGame mcqgame = isMCQ(cid,gid);
		TFGame tfgame = isTF(cid,gid);
		
		if(mcqgame != null){
			List<MCQQuestion> questions = mcqQuestionRepoService.getQuestionsOfGame(gid);
			mcqgame.setNumberOfQuestions(questions.size());
			model.addAttribute("user_id",user_id);
			model.addAttribute("cid",cid);
			model.addAttribute("game",mcqgame);
			if(teacherRepoService.getTeacher(user_id) != null)
				model.addAttribute("t_user",true);
			for(int i =0;i < questions.size();i++){
				model.addAttribute("question"+(i+1)+"Title", questions.get(i).getQuestion());
				model.addAttribute("question"+(i+1)+"View",true);
				model.addAttribute("question"+(i+1)+"Choice1",questions.get(i).getChoice1());
				model.addAttribute("question"+(i+1)+"Choice2",questions.get(i).getChoice2());
				model.addAttribute("question"+(i+1)+"Choice3",questions.get(i).getChoice3());
				model.addAttribute("question"+(i+1)+"Choice4",questions.get(i).getChoice4());
			}
			return "GlobalItems/MCQGamePage";

		}
		else if(tfgame != null){
			List<TFQuestion> questions = tfQuestionRepoService.getQuestionsOfGame(gid);
			tfgame.setNumberOfQuestions(questions.size());
			model.addAttribute("user_id",user_id);
			model.addAttribute("cid",cid);
			model.addAttribute("game",tfgame);
			if(teacherRepoService.getTeacher(user_id) != null)
				model.addAttribute("t_user",true);
			for(int i =0;i < questions.size();i++){
				model.addAttribute("question"+(i+1)+"Title", questions.get(i).getQuestion());
				model.addAttribute("question"+(i+1)+"View",true);
			}
			return "GlobalItems/TFGamePage";
		}
		else{
			return "";
		}
	}
	
	@RequestMapping(value = "/{user_id}/Course/{cid}/Game/{gid}",method = RequestMethod.POST)
	public String submitAnswers(@ModelAttribute("answers") Answers user_answers, Model model,
			@PathVariable String user_id, @PathVariable long cid, @PathVariable long gid){
		
		MCQGame mcqgame = isMCQ(cid,gid);
		int counter = 0;
		if(mcqgame != null){
			List<MCQQuestion> questions = mcqQuestionRepoService.getQuestionsOfGame(gid);
			
			for(int i =0;i < questions.size();i++)
				if(questions.get(i).getCorrect_answer().equals(user_answers.getUser_answers()[i]))
					counter++;
			
			model.addAttribute("counter",counter);
			model.addAttribute("numberOfQuestions",questions.size());
			if(counter == questions.size())
				model.addAttribute("winner",true);
		}
		else{
			List<TFQuestion> questions = tfQuestionRepoService.getQuestionsOfGame(gid);
			
			for(int i =0;i < questions.size();i++)
				if(questions.get(i).getCorrect_answer().equals(user_answers.getUser_answers()[i]))
					counter++;
			
			model.addAttribute("counter",counter);
			model.addAttribute("numberOfQuestions",questions.size());
			if(counter == questions.size())
				model.addAttribute("winner",true);
		}
		
		model.addAttribute("user_id",user_id);
		model.addAttribute("cid",cid);
		model.addAttribute("gid",gid);
		if(teacherRepoService.getTeacher(user_id) != null)
			model.addAttribute("t_user", true);
		
		return "GlobalItems/GameResult";
	}
		
	public boolean Validate(long cid, String name) {
		
		if(tfGameRepoService.getGameByCourseAndName(cid, name)!=null
				|| mcqGameRepoService.getGameByCourseAndName(cid, name)!=null)
			return false;
		else
			return true;
	}

	public MCQGame isMCQ(long cid,long gid){
		return mcqGameRepoService.getGameInCourse(cid,gid);
	}
	
	public TFGame isTF(long cid,long gid){
		return tfGameRepoService.getGameInCourse(cid,gid);
	}

}
