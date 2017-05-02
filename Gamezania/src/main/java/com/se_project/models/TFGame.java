/**
 * 
 */
package com.se_project.models;

import java.util.ArrayList;

import javax.persistence.Transient;

/**
 * This represents the True/False taxonomy of the game entity
 * 
 */
public class TFGame extends Game {
	
	TFQuestion[] tfquestions;
	
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

	public TFGame(TFGame other){
		super(other);
	}
	
	/**
	 * @return the tfquestions
	 */
	public TFQuestion[] getTfquestions() {
		return tfquestions;
	}

	/**
	 * @param tfquestions the tfquestions to set
	 */
	public void setTfquestions(TFQuestion[] tfquestions) {
		this.tfquestions = tfquestions;
	}

	
	

}
