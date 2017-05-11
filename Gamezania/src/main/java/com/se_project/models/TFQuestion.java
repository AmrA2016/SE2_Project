
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
	Game tfgame;
	
	public TFQuestion() {
	}

	/**
	 * @param question
	 * @param correctAnswer
	 */
	public TFQuestion(String question, String correctAnswer) {
		super(question, correctAnswer);
		
	}
	
	public TFQuestion(TFQuestion other){
		super(other);
	}

	/**
	 * @return the tfgame
	 */
	public Game getTfgame() {
		return tfgame;
	}

	/**
	 * @param tfgame the tfgame to set
	 */
	public void setTfgame(Game tfgame) {
		this.tfgame = tfgame;
	}

}
