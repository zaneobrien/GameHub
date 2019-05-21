package com.game.checkout.gamecheckout.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "UserId")
    private Long userId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password; //Temporary Type

    @Column(name = "DateAdded")
    private LocalDateTime dateAdded; 

    @Column(name = "LastModified")
    private LocalDateTime lastModified; //Is LocalDateTime an issue for JPA to convert?

    public User() {} // default constructor

    public User(String name, String email, String password, LocalDateTime dateAdded, LocalDateTime lastModified) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.dateAdded = dateAdded;
        this.lastModified = lastModified;
    }


    public Long getUserId() {
        return this.userId;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public LocalDateTime getDateAdded(){
        return this.dateAdded;
    }

    public LocalDateTime getLastModified(){
        return this.lastModified;
    }
    
    public String toString() {
    	StringBuffer sb = new StringBuffer();
    	
    	sb.append(userId).append(" ").append(name).append(" ").append(email);
    	
    	return sb.toString();
    }


}