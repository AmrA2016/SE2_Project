
package com.se_project.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


/**
 * The multiple choice question entity
 * and it holds all the attributes of T/F question 
 * <p>
 * It has a relation ManyToOne with tf_game
 */

@Entity(name="tfquestions")
public class TFQuestion extends Question {
	
	@ManyToOne
	private TFGame tfgame;
	
	public TFQuestion() {
	}

	/**
	 * @param question
	 * @param correctAnswer
	 */
	public TFQuestion(String question, String correctAnswer) {
		super(question, correctAnswer);
		
	}

	/**
	 * @return the tfGame
	 */
	public TFGame getTfGame() {
		return tfgame;
	}

	/**
	 * @param tfGame the tfGame to set
	 */
	public void setTfGame(TFGame tfGame) {
		this.tfgame = tfGame;
	}

}
