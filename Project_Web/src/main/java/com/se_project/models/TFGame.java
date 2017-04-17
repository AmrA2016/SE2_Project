/**
 * 
 */
package com.se_project.models;

import javax.persistence.Entity;

/**
 * This represents the True/False taxonomy of the game entity
 * 
 */
@Entity(name="tfgames")
public class TFGame extends Game {
	
	
	public TFGame() {
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
	public TFGame(String name, String description, String image, int numberOFQuestions, String[] questions,
			String[] correctAnswers) {
		super(name, description, image, numberOFQuestions, questions, correctAnswers);
	}
	
	

}
