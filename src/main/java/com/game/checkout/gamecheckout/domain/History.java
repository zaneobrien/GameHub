package com.game.checkout.gamecheckout.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "HistoryId")
    private Long historyId;

    @Column(name = "UserId")
    private Long userId;
    
    @Column(name = "GameId")
    private Long gameId;

    @Column(name = "DateCheckedOut")
    private LocalDateTime dateCheckedOut;

    @Column(name = "DateCheckedIn")
    private LocalDateTime dateCheckedIn;

    public History() {}

    public History(Long userId, Long gameId, LocalDateTime dateCheckedOut, LocalDateTime dateCheckedIn){
        this.userId = userId;
        this.gameId = gameId;
        this.dateCheckedOut = dateCheckedOut;
        this.dateCheckedIn = dateCheckedIn;
    }

    public Long getHistoryId(){
        return this.historyId;
    }

    public Long getUserId(){
        return this.userId;
    }

    public Long getGameId(){
        return this.gameId;
    }

    public LocalDateTime getDateCheckedOut(){
        return this.dateCheckedOut;
    }

    public LocalDateTime getDateCheckedIn(){
        return this.dateCheckedIn;
    }

}