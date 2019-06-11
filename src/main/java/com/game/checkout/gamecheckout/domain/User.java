package com.game.checkout.gamecheckout.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "UserId")
    private Long userId;

    //Used as login username
    @Email(message = "Please enter a valid email")
    @Column(name = "Email", unique = true)
    private String email;

    @NotNull(message = "Name is required to enter a User")
    @Column(name = "Name")
    private String name;

    //@Column(name = "Password")
    //private String password; //Temporary Type

    @Column(name = "DateAdded")
    private LocalDateTime dateAdded = LocalDateTime.now(); 

    @Column(name = "LastModified")
    private LocalDateTime lastModified = LocalDateTime.now();
    
    @OneToMany(mappedBy="User")
    private List <History> histories;
    
    public User() {} // default constructor

    public User(String name, String email, LocalDateTime dateAdded, LocalDateTime lastModified) {
        this.name = name;
        this.email = email;
        //this.password = password;
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

    /*public String getPassword(){
        return this.password;
    }*/

    public LocalDateTime getDateAdded(){
        return this.dateAdded;
    }

    public LocalDateTime getLastModified(){
        return this.lastModified;
    }
	public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    /*public void setPassword(String password) {
        this.password = password;
    }*/

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }
    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }
    
    public String toString() {
    	StringBuffer sb = new StringBuffer();
    	
    	sb.append(userId).append(" ").append(name).append(" ").append(email);
    	
    	return sb.toString();
    }


}