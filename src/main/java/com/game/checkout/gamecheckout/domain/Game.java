package com.game.checkout.gamecheckout.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "GameId")
	private String gameId;
	private String title;
	private String playerCount;
	private Integer playTime;
	private Integer age;
	private Integer complexity;
	private String designer;
	private String publisher;
	private String yearPublished;
	private String rating;
	private LocalDateTime dateAdded;
	private LocalDateTime lastModified;
	
	// TODO: possibly use Builder pattern to build object since most of these parameters are optional
	public Game(String gameId, String title, String playerCount, Integer playTime, Integer age, Integer complexity,
			String designer, String publisher, String yearPublished, String rating, LocalDateTime dateAdded,
			LocalDateTime lastModified) {
		super();
		this.gameId = gameId;
		this.title = title;
		this.playerCount = playerCount;
		this.playTime = playTime;
		this.age = age;
		this.complexity = complexity;
		this.designer = designer;
		this.publisher = publisher;
		this.yearPublished = yearPublished;
		this.rating = rating;
		this.dateAdded = dateAdded;
		this.lastModified = lastModified;
	}

	public String getGameId() {
		return gameId;
	}

	public String getTitle() {
		return title;
	}

	public String getPlayerCount() {
		return playerCount;
	}

	public Integer getPlayTime() {
		return playTime;
	}

	public Integer getAge() {
		return age;
	}

	public Integer getComplexity() {
		return complexity;
	}

	public String getDesigner() {
		return designer;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getYearPublished() {
		return yearPublished;
	}

	public String getRating() {
		return rating;
	}

	public LocalDateTime getDateAdded() {
		return dateAdded;
	}

	public LocalDateTime getLastModified() {
		return lastModified;
	}
	
}