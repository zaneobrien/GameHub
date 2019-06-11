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

@Entity
@Table(name="History")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "HistoryId")
    private Long historyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GameId")
    private Game game;

    @Column(name = "DateCheckedOut")
    private LocalDateTime dateCheckedOut;

    @Column(name = "DateCheckedIn")
    private LocalDateTime dateCheckedIn;

    public History() {}

    public History(LocalDateTime dateCheckedOut, LocalDateTime dateCheckedIn){
       
        this.dateCheckedOut = dateCheckedOut;
        this.dateCheckedIn = dateCheckedIn;
    }

    public Long getHistoryId(){
        return this.historyId;
    }

    public LocalDateTime getDateCheckedOut(){
        return this.dateCheckedOut;
    }

    public LocalDateTime getDateCheckedIn(){
        return this.dateCheckedIn;
    }

}