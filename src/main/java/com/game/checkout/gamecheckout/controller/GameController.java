package com.game.checkout.gamecheckout.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.checkout.gamecheckout.domain.Game;
import com.game.checkout.gamecheckout.repository.GameRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GameController {

	private final GameRepository gameRepository;
	
    GameController(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }
    
    @GetMapping("/getGames")
    public List<Game> getGames() {
    	return (List<Game>) gameRepository.findAll();
    }
}
