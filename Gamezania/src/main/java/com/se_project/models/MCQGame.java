
package com.se_project.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

/**
 * This represents the multiple choice taxonomy of the game entity
 * 
 */

public class MCQGame extends Game {
	
	MCQQuestion[] mcqquestions ;
	
	
	/**
	 * Choices for each question that teacher enter which must 4 choices
	 * This doens't stored in the database
	 */
	@Transient
	private String[][] choices = new String[5][4];

	public MCQGame() {
		super();
		setGame_type("MCQ");
	}
	
	public MCQGame(long gid){
		super(gid);
		setGame_type("MCQ");
	}

	
	/**
	 * @param name
	 * @param description
	 * @param comments
	 * @param image
	 * @param course
	 * @param deleted
	 */
	public MCQGame(String name, String description,List<Comment> comments, String image, Course course, boolean deleted) {
		super(name, description,comments, image,course);
		setGame_type("MCQ");
	}
	
	/**
	 * @param name
	 * @param description
	 * @param image
	 * @param numberOFQuestions
	 * @param questions
	 * @param correctAnswers
	 */
	public MCQGame(String name, String description, List<Comment> comments, String image, int numberOFQuestions, String[] questions,
			String[] correctAnswers, Course course, boolean deleted) {
		super(name, description,comments, image, numberOFQuestions, questions, correctAnswers,course,deleted);
		setGame_type("MCQ");
	}
	
	
	public MCQGame(Game other){
		super(other);
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

	/**
	 * @return the mcqquestions
	 */
	public MCQQuestion[] getMcqquestions() {
		return mcqquestions;
	}

	/**
	 * @param mcqquestions the mcqquestions to set
	 */
	public void setMcqquestions(MCQQuestion[] mcqquestions) {
		this.mcqquestions = mcqquestions;
	}

	
	

	
	
	
}
