/**
 * 
 */
package com.se_project.models;

import java.util.ArrayList;
import java.util.List;

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

	public TFGame(long gid){
		super(gid);
		setGame_type("TF");
	}
	
	/**
	 * @param name
	 * @param description
	 * @param comments
	 * @param image
	 * @param course
	 * @param deleted
	 */
	public TFGame(String name, String description,List<Comment> comments, String image, Course course, boolean deleted) {
		super(name, description,comments, image,course);
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
	public TFGame(String name, String description, List<Comment> comments, String image, int numberOFQuestions, String[] questions,
			String[] correctAnswers, Course course, boolean deleted) {
		super(name, description,comments, image, numberOFQuestions, questions, correctAnswers,course,deleted);
		setGame_type("TF");
	}

	public TFGame(Game other){
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
