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
	private Integer gameId;

	@Column(name = "Title")
	private String title;

	@Column(name = "PlayerCount")
	private String playerCount;

	@Column(name = "PlayTime")
	private Integer playTime;

	@Column(name = "Age")
	private Integer age;

	@Column(name = "Complexity")
	private Integer complexity;

	@Column(name = "Designer")
	private String designer;

	@Column(name = "Publisher")
	private String publisher;

	@Column(name = "YearPublished")
	private String yearPublished;

	@Column(name = "Rating")
	private String rating;

	@Column(name = "DateAdded")
	private LocalDateTime dateAdded;

	@Column(name = "LastModified")
	private LocalDateTime lastModified;
	
	public Game() {}
	
	public Game(String title, String playerCount, Integer playTime, Integer age, Integer complexity,
			String designer, String publisher, String yearPublished, String rating, LocalDateTime dateAdded,
			LocalDateTime lastModified) {
		super();
		//this.gameId = gameId;
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

	public Integer getGameId() {
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

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPlayerCount(String playerCount) {
		this.playerCount = playerCount;
	}

	public void setPlayTime(Integer playTime) {
		this.playTime = playTime;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setComplexity(Integer complexity) {
		this.complexity = complexity;
	}

	public void setDesigner(String designer) {
		this.designer = designer;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setYearPublished(String yearPublished) {
		this.yearPublished = yearPublished;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public void setDateAdded(LocalDateTime dateAdded) {
		this.dateAdded = dateAdded;
	}

	public void setLastModified(LocalDateTime lastModified) {
		this.lastModified = lastModified;
	}
	
}