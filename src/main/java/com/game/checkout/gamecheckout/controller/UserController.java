package com.game.checkout.gamecheckout.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.game.checkout.gamecheckout.domain.User;
import com.game.checkout.gamecheckout.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
 
	private final UserRepository userRepository;
	
    // standard constructor
    UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
     
    @GetMapping("/getUser")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
 
    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {
    	
        userRepository.save(user);
    }

    @PutMapping("updateUser")
    public @ResponseBody String updateGame(@RequestBody User user){
        this.userRepository.save(user);
        return "Updated";
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
        userRepository.findAll().forEach(p -> System.out.println(p));
    }
    
    @GetMapping("/reset")
    public void reset() {
    	userRepository.deleteAll();
    }
    
    @Transactional
    @GetMapping("/user/{name}")
    public List <User> getUsersByName(@PathVariable("name") String name) {
    	
    	return userRepository.findAllByName(name);
    }
    
    @Transactional
    @GetMapping("/user/thing/{something}")
    public List <User> getUsersBySomething(@PathVariable("something") String something) {
    	
    	return userRepository.findAllByEmail(something).collect(Collectors.toList());
    }
    
}