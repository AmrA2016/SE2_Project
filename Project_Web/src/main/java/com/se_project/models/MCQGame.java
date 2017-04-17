
package com.se_project.models;

import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * This represents the multiple choice taxonomy of the game entity
 * 
 */

@Entity(name = "mcqgames")
public class MCQGame extends Game {
	
	
	/**
	 * Choices for each question that teacher enter which must 4 choices
	 * This doens't stored in the database
	 */
	@Transient
	private String[][] choices = new String[5][4];

	public MCQGame() {
		super();
	}

	/**
	 * @param name
	 * @param description
	 * @param image
	 * @param numberOFQuestions
	 * @param questions
	 * @param correctAnswers
	 */
	public MCQGame(String name, String description, String image, int numberOFQuestions, String[] questions,
			String[] correctAnswers) {
		super(name, description, image, numberOFQuestions, questions, correctAnswers);
	}

	/**
	 * @return the choices
	 */
	public String[][] getChoices() {
		return choices;
	}

	/**
	 * @param choices the choices to set
	 */
	public void setChoices(String[][] choices) {
		this.choices = choices;
	}

	
	
	
}
