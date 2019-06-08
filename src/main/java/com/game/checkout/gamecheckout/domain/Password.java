package com.game.checkout.gamecheckout.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Password {
   
    @Id
    private Long passwordId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    @Column(name = "Password")
    private String password; //TODO: Update type?

    public Password() {} // default constructor

    public Password(User user, String password) {
        this.user = user;
        this.password = password;
    }

    //TODO: Should all of these be available?
    /* Auto Generated Getters/Setters */
    public Long getPasswordId() {
        return this.passwordId;
    }

    public void setPasswordId(Long passwordId) {
        this.passwordId = passwordId;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}