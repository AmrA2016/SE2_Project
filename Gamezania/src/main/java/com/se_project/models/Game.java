package com.se_project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

/**
 * This represents the game entity 
 * and It holds the generic attributes 
 * <p>
 * This entity doesn't stored in the database but its children are stored
 */
@Entity(name="games")
public class Game implements Comparable<Game>{
	
	
	/**
	 * game_id 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long gid;
	
	@NotNull
	@Size(min = 2, max = 50)
	protected  String name;
	@NotEmpty
	@Size(max = 1000)
	protected String description;
	
	private String game_type;
	
	/**
	 * Image file name
	 */
	protected String image;
	
	/**
	 * This holds the number of questions in the game
	 * It doesn't stored in the database used only for validation
	 */
	@Transient
	@Min(value = 1, message="There should at least 1 question" )
	@Max(5)
	protected int numberOfQuestions;
	
	/**
	 * This holds or receives the questions of the game that teacher enters
	 * It's temporary and doesn't stored in database
	 */
	@Transient
	protected String[] questions = new String[5];
	/**
	 * This holds or receives the answers of the questions that teacher enters
	 * It's temporary and doesn't stored in database
	 */
	@Transient
	protected String[] correctAnswers = new String[5];
	
	/**
	 * Course object that link this game to a certain course
	 */
	@ManyToOne
	protected Course course;
	
	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	public Game() {
	
	}
	
	/**
	 * @param name
	 * @param description
	 * @param image
	 * @param numberOFQuestions
	 * @param questions
	 * @param correctAnswers
	 */
	public Game(String name, String description, String image, int numberOFQuestions, String[] questions,
			String[] correctAnswers) {
		this.name = name;
		this.description = description;
		this.image = image;
		this.numberOfQuestions = numberOFQuestions;
		this.questions = questions;
		this.correctAnswers = correctAnswers;
	}

	/**
	 * @return the game id
	 */
	public long getGid() {
		return gid;
	}

	/**
	 * @param id the game id to set
	 */
	public void setGid(long id) {
		this.gid = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the game_type
	 */
	public String getGame_type() {
		return game_type;
	}

	/**
	 * @param game_type the game_type to set
	 */
	public void setGame_type(String game_type) {
		this.game_type = game_type;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the numberOFQuestions
	 */
	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}

	/**
	 * @param numberOFQuestions the numberOFQuestions to set
	 */
	public void setNumberOfQuestions(int numberOFQuestions) {
		this.numberOfQuestions = numberOFQuestions;
	}

	/**
	 * @return the questions
	 */
	public String[] getQuestions() {
		return questions;
	}

	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(String[] questions) {
		this.questions = questions;
	}

	/**
	 * @return the correctAnswers
	 */
	public String[] getCorrectAnswers() {
		return correctAnswers;
	}

	/**
	 * @param correctAnswers the correctAnswers to set
	 */
	public void setCorrectAnswers(String[] correctAnswers) {
		this.correctAnswers = correctAnswers;
	}
	
	@Override
	public int compareTo(Game other) {
		return this.name.compareTo(other.name);
	}
	
	
}
