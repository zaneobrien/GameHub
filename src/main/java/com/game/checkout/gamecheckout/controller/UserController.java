package com.game.checkout.gamecheckout.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.game.checkout.gamecheckout.domain.User;
import com.game.checkout.gamecheckout.domain.Password;
import com.game.checkout.gamecheckout.repository.PasswordRepository;
import com.game.checkout.gamecheckout.repository.UserRepository;

@RestController
// TODO: figure out how to add the server.address here to the CrossOrigin
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
 
    private final UserRepository userRepository;
    private final PasswordRepository passwordRepository;  //TODO: Should this be in its own repo class?  Its tightly coupled
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    //TODO: Discuss?
    @Value("${app.message}")
    private String testing;
	
    // standard constructor
    UserController(UserRepository userRepository, PasswordRepository passwordRepository){
        this.userRepository = userRepository;
        this.passwordRepository = passwordRepository;
    }
     
    @GetMapping("/getUsers")
    public List<User> getUsers() {
        System.out.println(testing);
        return (List<User>) userRepository.findAll();
    }
 
    @PostMapping("/addUser/{password}")
    public @ResponseBody String addUser(@RequestBody User user, @PathVariable("password") String passwordStr) {
        
        //Password Security
        String hashedPassword = passwordEncoder.encode(passwordStr);
        Password password = new Password(user, hashedPassword);

        userRepository.save(user);
        passwordRepository.save(password);


        return "User Added";
    }

    //TODO: Discuss whether this is a good method of passing login info, is the password unsafe in the URL
    @PostMapping("/authenticate/{userEmail}/{password}")
    public @ResponseBody String authenticate(@PathVariable("userEmail") String userEmail, @PathVariable("password") String password){
        
        //Get user from given email
        User user = getUserByEmail(userEmail); //TODO: Is this a proper reuse of code below?
        
        //Check if password matches
        if(passwordEncoder.matches(password, passwordRepository.findByUser(user).getPassword())){
            return "Success";
        }
        return "Fail";
    }
    
    @GetMapping("/userCount")
    public Integer getUserCount() {
    	return ((List<User>) userRepository.findAll()).size();
    }
    
    @GetMapping("/reload")
    public void reload() {
    	Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
            User user = new User(name,name + "@domain.com", LocalDateTime.now(), LocalDateTime.now());
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
    @GetMapping("/user/email/{email}")
    public User getUserByEmail(@PathVariable("email") String email) {
    	return userRepository.findByEmail(email);
    }
    
    @Transactional
    @GetMapping("/user/thing/{something}")
    public List <User> getUsersBySomething(@PathVariable("something") String something) {
    	
    	return userRepository.findAllByEmail(something).collect(Collectors.toList());
    }
    
}