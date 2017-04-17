/**
 * 
 */
package com.se_project.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Amr
 *
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
