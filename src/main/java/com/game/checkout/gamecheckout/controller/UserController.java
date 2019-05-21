package com.game.checkout.gamecheckout.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.game.checkout.gamecheckout.domain.User;
import com.game.checkout.gamecheckout.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
 
    // standard constructor
    UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
     
    private final UserRepository userRepository;
 
    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
 
    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
    
    @GetMapping("/userCount")
    public Integer getUserCount() {
    	return ((List<User>) userRepository.findAll()).size();
    }
    
    @GetMapping("/reload")
    public void reload() {
    	Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
            User user = new User(name,name + "@domain.com","Passwordhere", LocalDateTime.now(), LocalDateTime.now());
            userRepository.save(user);
        });
        userRepository.findAll().forEach(p -> System.out.println(p.getUserId() + " " + p.getName() + " " + p.getEmail())
        		);
    }
}