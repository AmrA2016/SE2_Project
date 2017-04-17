
package com.se_project.models;

import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * @author Amr
 * 
 */

@Entity(name = "mcqgames")
public class MCQGame extends Game {
	

	
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

	public String[][] getChoices() {
		return choices;
	}

	public void setChoices(String[][] choices) {
		this.choices = choices;
	}
	
	
}
