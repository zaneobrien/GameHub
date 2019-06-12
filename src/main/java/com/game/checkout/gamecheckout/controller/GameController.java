package com.game.checkout.gamecheckout.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.game.checkout.gamecheckout.domain.Game;
import com.game.checkout.gamecheckout.repository.GameRepository;

@RestController
// TODO: figure out how to add the server.address here to the CrossOrigin
@CrossOrigin(origins = "http://localhost:4200")
public class GameController {

	private final GameRepository gameRepository;
	
    GameController(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }
    
    @GetMapping("/games")
    public List<Game> getGames() {
    	return (List<Game>) gameRepository.findAll();
    }
    
    @GetMapping("/games/{id}")
    public Game getGameById(@PathVariable String id) {
    	
    	System.out.println("id = " + id);
    	
    	Optional <Game> game = gameRepository.findById(Long.valueOf(id));
    	if (game.isPresent()) {
    		return game.get();
    	} else {
    		return null;
    	}
    }
    
    @PostMapping("/addGame")
    public void setGame(@RequestBody Game game) {
    	this.gameRepository.save(game);
    }
    
}
