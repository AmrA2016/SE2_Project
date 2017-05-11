/**
 * 
 */
package com.se_project.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * This represents the question entity 
 * and it holds the generic attributes of the question
 * <p>
 * This entity doens't stored in the database but its children are stored
 *	
 */
@MappedSuperclass
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
	protected String question;
	protected String correct_answer;
	
	
	public Question(){
		
	}
	
	/**
	 * @param question
	 * @param correctAnswer
	 */
	public Question(String question, String correctAnswer) {
		super();
		this.question = question;
		this.correct_answer = correctAnswer;
	}
	
	public Question(Question other){
		this.question = other.question;
		this.correct_answer = other.correct_answer;
	}
	
	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the correctAnswer
	 */
	public String getCorrect_answer() {
		return correct_answer;
	}

	/**
	 * @param correctAnswer the correctAnswer to set
	 */
	public void setCorrectAnswer(String correctAnswer) {
		this.correct_answer = correctAnswer;
	}

	
	
}
