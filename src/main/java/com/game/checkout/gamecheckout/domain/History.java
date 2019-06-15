package com.game.checkout.gamecheckout.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="History")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "HistoryId")
    private Long historyId;

    @Column(name = "Action")
    private Action action;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    private User user;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GameId")
    private Game game;

    @Column(name = "Timestamp")
    private LocalDateTime timestamp;

    public enum Action {
    	CHECKOUT,
    	CHECKIN;
    	
    	public Action toggle() {
    		if (this.equals(CHECKOUT)) {
    			return CHECKIN;
    		}
    		else {
    			return CHECKOUT;
    		}
    	}
    }

    public History() {}
    
    public History(Action action, User user, Game game, LocalDateTime timestamp) {
    	this.action = action;
    	this.user = user;
    	this.game = game;
    	this.timestamp = timestamp;
    }

    public Long getHistoryId(){
        return this.historyId;
    }

    public Action getAction() {
    	return this.action;
    }
    
    public User getUser() {
    	return this.user;
    }
    
    public Game getGame() {
    	return this.game;
    }
    
    public LocalDateTime getTimestamp() {
    	return this.timestamp;
    }

}