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
import com.se_project.controllers.services.GameRepositoryService;
import com.se_project.controllers.services.MCQQuestionRepositoryService;
import com.se_project.controllers.services.TFQuestionRepositoryService;
import com.se_project.controllers.services.TeacherRepositoryService;
import com.se_project.models.Answers;
import com.se_project.models.Game;
import com.se_project.models.MCQGame;
import com.se_project.models.MCQQuestion;
import com.se_project.models.TFGame;
import com.se_project.models.TFQuestion;

/**
 * This class implements the controller functions that link between the game
 * model and its views.
 *
 */
@Controller
public class GameController {
	
	String mcq = "MCQ";
	String tf = "TF";
	
	@Autowired
	GameRepositoryService gameRepoService;

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

	/**
	 * @param mcqGame
	 *            object holds the data of the game which will be created
	 * @param teacher_id
	 *            identifies the teacher through the system
	 * @param cid
	 *            identify the course through the system
	 * @return HTML page contains the form of creating a game
	 */
	@RequestMapping(value = "/{teacher_id}/Course/{cid}/createMCQGame", method = RequestMethod.GET)
	public String CreateMCQGameForm(Model model, @ModelAttribute("mcqGame") MCQGame mcqGame,
			@PathVariable String teacher_id, @PathVariable long cid) {
		if (!UserController.current_user.equals(teacher_id))
			return "redirect:/";
		model.addAttribute("teacher_id", teacher_id);
		model.addAttribute("cid", cid);

		return "Teacher/createMCQGame";
	}

	/**
	 * @param tfGame
	 *            object of the "true or false" game which will be created
	 * @param teacher_id
	 *            identifies a teacher through the system
	 * @param cid
	 *            identifies a course through the system
	 * @return HTML page contains a form for creating "true or false" game
	 */
	@RequestMapping(value = "/{teacher_id}/Course/{cid}/createTfGame", method = RequestMethod.GET)
	public String CreateTFGameForm(Model model, @ModelAttribute("tfGame") TFGame tfGame,
			@PathVariable String teacher_id, @PathVariable long cid) {
		if (!UserController.current_user.equals(teacher_id))
			return "redirect:/";
		model.addAttribute("teacher_id", teacher_id);
		model.addAttribute("cid", cid);
		return "Teacher/createTfGame";
	}

	/**
	 * @param mcqGame
	 *            object of the "multiple choice questions" game which will be
	 *            created
	 * @param teacher_id
	 *            identifies a teacher through the system
	 * @param cid
	 *            identifies a course through the system
	 * @param imagefile
	 *            path of the course image added by a teacher
	 * @return HTML page of the teacher's course page updated with the new game
	 *         or returns HTML page of the create "MCQ" game if the data entered
	 *         is wrong
	 */
	@RequestMapping(value = "/{teacher_id}/Course/{cid}/createMCQGame", method = RequestMethod.POST)
	public String CreateMCQGame(@Valid @ModelAttribute("mcqGame") MCQGame mcqGame, BindingResult bindingResult,
			Model model, @PathVariable String teacher_id, @PathVariable long cid,
			@RequestParam("imagefile") MultipartFile imagefile) {

		if (bindingResult.hasErrors() || mcqGame.getName().contains("/")) {
			return "Teacher/createMCQGame";
		} else if (!Validate(cid, mcqGame.getName())) {
			model.addAttribute("Wrongname", true);
			return "Teacher/createMCQGame";
		} else if (imagefile.isEmpty()) {
			model.addAttribute("image_empty", true);
			return "Teacher/createMCQGame";
		}

		mcqGame.setCourse(courseRepoService.getCourse(cid));

		mcqGame.setImage(imageService.storeImage(imagefile));
       
		Game game = new Game(mcqGame);
		gameRepoService.saveGame(game);
		for (int i = 0; i < mcqGame.getNumberOfQuestions(); i++) {
			MCQQuestion question = new MCQQuestion();
			question.setQuestion(mcqGame.getQuestions()[i]);
			String[] choices = mcqGame.getChoices()[i];
			String correctIndex = mcqGame.getCorrectAnswers()[i];
			question.setCorrectAnswer(choices[Integer.parseInt(correctIndex)]);
			question.setChoice1(choices[0]);
			question.setChoice2(choices[1]);
			question.setChoice3(choices[2]);
			question.setChoice4(choices[3]);
			question.setMcqgame(game);
			mcqQuestionRepoService.saveQuestion(question);
		}

		return "redirect:/" + teacher_id + "/Course/" + cid;

	}

	/**
	 * this function takes data of "true or false" game by a teacher and creates
	 * it
	 * 
	 * @param tfGame
	 *            object of the "true or false" game which will be created
	 * @param teacher_id
	 *            identifies a teacher through the system
	 * @param cid
	 *            identifies a course through the system
	 * @param imagefile
	 *            path of the course image added by a teacher
	 * @return HTML page of the teacher's course page updated with the new game
	 *         or returns HTML page of the create "true or false" game if the
	 *         data entered is wrong
	 */
	@RequestMapping(value = "/{teacher_id}/Course/{cid}/createTfGame", method = RequestMethod.POST)
	public String CreateTOrFGame(@Valid @ModelAttribute("tfGame") TFGame tfGame, BindingResult bindingResult,
			Model model, @PathVariable String teacher_id, @PathVariable long cid,
			@RequestParam("imagefile") MultipartFile imagefile) {

		if (bindingResult.hasErrors() || tfGame.getName().contains("/")) {
			return "Teacher/createTfGame";
		} else if (!Validate(cid, tfGame.getName())) {
			model.addAttribute("Wrongname", true);
			return "Teacher/createTfGame";
		} else if (imagefile.isEmpty()) {
			model.addAttribute("image_empty", true);
			return "Teacher/createTfGame";
		}

		tfGame.setCourse(courseRepoService.getCourse(cid));

		tfGame.setImage(imageService.storeImage(imagefile));

		Game game = new Game(tfGame);
		gameRepoService.saveGame(game);
		for (int i = 0; i < tfGame.getNumberOfQuestions(); i++) {
			TFQuestion question = new TFQuestion();
			question.setQuestion(tfGame.getQuestions()[i]);
			question.setCorrectAnswer(tfGame.getCorrectAnswers()[i]);
			question.setTfgame(game);
			tfQuestionRepoService.saveQuestion(question);
		}

		return "redirect:/" + teacher_id + "/Course/" + cid;

	}

	/**
	 * this function checks if the requested game is "true or false" game or
	 * "Multiple choice questions" game
	 * 
	 * @param user_answers
	 *            object of the user answers to the questions of a specific game
	 * @param user_id
	 *            identifies the user through the system
	 * @param cid
	 *            identifies the course through the system
	 * @param gid
	 *            identifies the game through the system
	 * @return HTML page of "true or false" game or HTML page of " Multiple
	 *         choice questions" game (depends on the type of the game)
	 */
	@RequestMapping(value = "/{user_id}/Course/{cid}/Game/{gameId}", method = RequestMethod.GET)
	public String getGame(@ModelAttribute("answers") Answers user_answers, Model model, @PathVariable String user_id,
			@PathVariable long cid, @PathVariable long gameId) {

		if (!UserController.current_user.equals(user_id))
			return "redirect:/";
		
		Game game = gameRepoService.getGame(gameId);
		
		if (game.getGame_type().equals(mcq)) {
			List<MCQQuestion> questions = mcqQuestionRepoService.getQuestionsOfGame(game.getGid());
			game.setNumberOfQuestions(questions.size());
			model.addAttribute("user_id", user_id);
			model.addAttribute("cid", cid);
			model.addAttribute("game", game);
			if (teacherRepoService.getTeacher(user_id) != null)
				model.addAttribute("t_user", true);
			for (int i = 0; i < questions.size(); i++) {
				model.addAttribute("question" + (i + 1) + "Title", questions.get(i).getQuestion());
				model.addAttribute("question" + (i + 1) + "View", true);
				model.addAttribute("question" + (i + 1) + "Choice1", questions.get(i).getChoice1());
				model.addAttribute("question" + (i + 1) + "Choice2", questions.get(i).getChoice2());
				model.addAttribute("question" + (i + 1) + "Choice3", questions.get(i).getChoice3());
				model.addAttribute("question" + (i + 1) + "Choice4", questions.get(i).getChoice4());
			}
			return "GlobalItems/MCQGamePage";

		} else if (game.getGame_type().equals(tf)) {
			List<TFQuestion> questions = tfQuestionRepoService.getQuestionsOfGame(game.getGid());
			game.setNumberOfQuestions(questions.size());
			model.addAttribute("user_id", user_id);
			model.addAttribute("cid", cid);
			model.addAttribute("game", game);
			if (teacherRepoService.getTeacher(user_id) != null)
				model.addAttribute("t_user", true);
			for (int i = 0; i < questions.size(); i++) {
				model.addAttribute("question" + (i + 1) + "Title", questions.get(i).getQuestion());
				model.addAttribute("question" + (i + 1) + "View", true);
			}
			return "GlobalItems/TFGamePage";
		} else {
			return "";
		}
	}

	/**
	 * this function takes the user answers for a game questions and checks if
	 * it is right or wrong
	 * 
	 * @param user_answers
	 *            object of the user answers to the questions of a specific game
	 * @param user_id
	 *            identifies the user through the system
	 * @param cid
	 *            identifies the course through the system
	 * @param gid
	 *            identifies the game through the system
	 * @return HTML page of the game result
	 */
	@RequestMapping(value = "/{user_id}/Course/{cid}/Game/{gameId}", method = RequestMethod.POST)
	public String submitAnswers(@ModelAttribute("answers") Answers user_answers, Model model,
			@PathVariable String user_id, @PathVariable long cid, @PathVariable long gameId) {

		Game game = gameRepoService.getGame(gameId);
		int counter = 0;
		if (game.getGame_type().equals(mcq)) {
			List<MCQQuestion> questions = mcqQuestionRepoService.getQuestionsOfGame(gameId);

			for (int i = 0; i < questions.size(); i++)
				if (questions.get(i).getCorrect_answer().equals(user_answers.getUser_answers()[i]))
					counter++;

			model.addAttribute("counter", counter);
			model.addAttribute("numberOfQuestions", questions.size());
			if (counter == questions.size())
				model.addAttribute("winner", true);
		} else {
			List<TFQuestion> questions = tfQuestionRepoService.getQuestionsOfGame(gameId);

			for (int i = 0; i < questions.size(); i++)
				if (questions.get(i).getCorrect_answer().equals(user_answers.getUser_answers()[i]))
					counter++;

			model.addAttribute("counter", counter);
			model.addAttribute("numberOfQuestions", questions.size());
			if (counter == questions.size())
				model.addAttribute("winner", true);
		}

		model.addAttribute("user_id", user_id);
		model.addAttribute("cid", cid);
		model.addAttribute("gameID", game.getGid());
		if (teacherRepoService.getTeacher(user_id) != null)
			model.addAttribute("t_user", true);

		return "GlobalItems/GameResult";
	}

	@RequestMapping(value = "/{teacher_id}/Course/{cid}/editTfGame/{gameId}", method=RequestMethod.GET)
	public String editGame(@ModelAttribute TFGame tfGame, Model model, @PathVariable String teacher_id,@PathVariable long cid, @PathVariable long gameId){
		model.addAttribute("teacher_id",teacher_id);
		model.addAttribute("cid",cid);
		Game temp = gameRepoService.getGame(gameId);
		TFGame oldTFGame = new TFGame();
		
		oldTFGame.setName(temp.getName());
		oldTFGame.setGid(temp.getGid());
		oldTFGame.setDescription(temp.getDescription());
		oldTFGame.setImage(temp.getImage());
		oldTFGame.setCourse(temp.getCourse());
		oldTFGame.setGame_type(temp.getGame_type());
		
		List<TFQuestion> tfQuestions = tfQuestionRepoService.getQuestionsOfGame(gameId);
		TFQuestion[] tfquestions = new TFQuestion[tfQuestions.size()];
		tfQuestions.toArray(tfquestions);
		oldTFGame.setTfquestions(tfquestions);
		oldTFGame.setNumberOfQuestions(tfQuestions.size());
		model.addAttribute("oldTFGame",oldTFGame);
		return "Teacher/editTfGame";
	}
	
	@RequestMapping(value = "/{teacher_id}/Course/{cid}/editTfGame/{gameId}", method=RequestMethod.POST)
	public String editGame(@ModelAttribute TFGame tfGame,Model model, BindingResult bindingResult, @PathVariable String teacher_id,
			@PathVariable long cid, @PathVariable long gameId, @RequestParam("imagefile") MultipartFile imagefile){
		
		if (bindingResult.hasErrors() || tfGame.getName().contains("/")) {
			return "Teacher/editTfGame";
		} else if (!Validate(cid, tfGame.getName())) {
			model.addAttribute("Wrongname", true);
			return "Teacher/editTfGame";
		} else if (imagefile.isEmpty()) {
			model.addAttribute("image_empty", true);
			return "Teacher/editTfGame";
		}
		
		tfGame.setCourse(courseRepoService.getCourse(cid));

		tfGame.setImage(imageService.storeImage(imagefile));

		Game game = new Game(tfGame);
		gameRepoService.saveGame(game);
		
		for (int i = 0; i < tfGame.getNumberOfQuestions(); i++) {
			TFQuestion question = new TFQuestion();
			question.setQuestion(tfGame.getQuestions()[i]);
			question.setCorrectAnswer(tfGame.getCorrectAnswers()[i]);
			question.setTfgame(game);
			tfQuestionRepoService.saveQuestion(question);
		}
		
		//TODO: Redirect to myGames page is the teacher is collaborator not owner
		return "redirect:/" + teacher_id + "/Course/" + cid;
	}
	
	/**
	 * this function delete a specific game from a specific course
	 * 
	 * @param user_id
	 *            identifies the user through the system
	 * @param cid
	 *            identifies the course through the system
	 * @param gameName
	 *            identifies the game in the course
	 * @return HTML page of a teacher courses page that show all his courses
	 */
	@RequestMapping("/{teacher_id}/Course/{cid}/DeleteGame/{gameId}")
	public String deleteGame(@PathVariable String teacher_id, @PathVariable long cid, @PathVariable long gameId) {
		if (!UserController.current_user.equals(teacher_id))
			return "redirect:/";

		gameRepoService.deleteGame(gameId);

		return "redirect:/" + teacher_id + "/Course/" + cid;
	}

	/**
	 * this function validate the game by checking if it is exists
	 * 
	 * @param cid
	 *            identifies a course through the system
	 * @param name
	 *            game name
	 * @return boolean value (true or false)
	 */
	public boolean Validate(long cid, String name) {

		if (gameRepoService.getGameByCourseAndName(cid, name) != null
				|| gameRepoService.getGameByCourseAndName(cid, name) != null)
			return false;
		else
			return true;
	}


}
