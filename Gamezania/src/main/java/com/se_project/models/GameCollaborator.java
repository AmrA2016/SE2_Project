package com.se_project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="game_collaborator")
public class GameCollaborator {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@ManyToOne
	Game game;
	@ManyToOne
	Teacher teacher;
	
	boolean owner;
	boolean accepted;
	
	/**
	 * 
	 */
	public GameCollaborator() {
		super();
	}
	
	/**
	 * @param id
	 * @param game
	 * @param teacher
	 * @param owner
	 * @param accepted
	 */
	public GameCollaborator(long id, Game game, Teacher teacher, boolean owner, boolean accepted) {
		super();
		this.id = id;
		this.game = game;
		this.teacher = teacher;
		this.owner = owner;
		this.accepted = accepted;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the game
	 */
	public Game getGame() {
		return game;
	}
	/**
	 * @param game the game to set
	 */
	public void setGame(Game game) {
		this.game = game;
	}
	/**
	 * @return the teacher
	 */
	public Teacher getTeacher() {
		return teacher;
	}
	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	/**
	 * @return the owner
	 */
	public boolean isOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(boolean owner) {
		this.owner = owner;
	}
	/**
	 * @return the accepted
	 */
	public boolean isAccepted() {
		return accepted;
	}
	/**
	 * @param accepted the accepted to set
	 */
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
}
