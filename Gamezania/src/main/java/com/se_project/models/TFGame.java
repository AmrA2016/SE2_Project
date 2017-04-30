/**
 * 
 */
package com.se_project.models;

import javax.persistence.Transient;

/**
 * This represents the True/False taxonomy of the game entity
 * 
 */
public class TFGame extends Game {
	
	TFQuestion[] tfquestions = new TFQuestion[5];
	
	public TFGame() {
		super();
		setGame_type("TF");
	}

	/**
	 * @param name
	 * @param description
	 * @param image
	 * @param numberOFQuestions
	 * @param questions
	 * @param correctAnswers
	 */
	public TFGame(String name, String description, String image, int numberOFQuestions, String[] questions,
			String[] correctAnswers) {
		super(name, description, image, numberOFQuestions, questions, correctAnswers);
		setGame_type("TF");
	}
	
	

}
