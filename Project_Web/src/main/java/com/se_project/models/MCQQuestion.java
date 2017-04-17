/**
 * 
 */
package com.se_project.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * The multiple choice question entity
 * and it holds all the attributes of mcq question 
 * <p>
 * It has a relation ManyToOne with mcqgame
 */
@Entity(name="mcqquestions")
public class MCQQuestion extends Question {
	
	private String choice1;
	private String choice2;
	private String choice3;
	private String choice4;
	
	
	/**
	 * MCQ game object that contains this question
	 */
	@ManyToOne
	private MCQGame mcqgame;
	
	

	public MCQQuestion() {
	}

	/**
	 * @param question
	 * @param correctAnswer
	 * @param choice1
	 * @param choice2
	 * @param choice3
	 * @param choice4
	 */
	public MCQQuestion(String question, String correctAnswer, String choice1, String choice2, String choice3, String choice4) {
		super(question, correctAnswer);
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
		this.choice4 = choice4;
	}

	/**
	 * @return the choice1
	 */
	public String getChoice1() {
		return choice1;
	}

	/**
	 * @param choice1 the choice1 to set
	 */
	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}

	/**
	 * @return the choice2
	 */
	public String getChoice2() {
		return choice2;
	}

	/**
	 * @param choice2 the choice2 to set
	 */
	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}

	/**
	 * @return the choice3
	 */
	public String getChoice3() {
		return choice3;
	}

	/**
	 * @param choice3 the choice3 to set
	 */
	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}

	/**
	 * @return the choice4
	 */
	public String getChoice4() {
		return choice4;
	}

	/**
	 * @param choice4 the choice4 to set
	 */
	public void setChoice4(String choice4) {
		this.choice4 = choice4;
	}
	
	/**
	 * @return the mcqGame
	 */
	public MCQGame getMcqGame() {
		return mcqgame;
	}

	/**
	 * @param mcqGame the mcqGame to set
	 */
	public void setMcqGame(MCQGame mcqGame) {
		this.mcqgame = mcqGame;
	}

}
