package com.game.checkout.gamecheckout.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.game.checkout.gamecheckout.domain.Game;
import com.game.checkout.gamecheckout.domain.History;
import com.game.checkout.gamecheckout.domain.History.Action;
import com.game.checkout.gamecheckout.domain.User;
import com.game.checkout.gamecheckout.repository.GameRepository;
import com.game.checkout.gamecheckout.repository.HistoryRepository;

@RestController
// TODO: figure out how to add the server.address here to the CrossOrigin
@CrossOrigin(origins = "http://localhost:4200")
public class GameController {

	private final GameRepository gameRepository;
	private final HistoryRepository historyRepository;
	
    GameController(GameRepository gameRepository, HistoryRepository historyRepository){
        this.gameRepository = gameRepository;
        this.historyRepository = historyRepository;
    }
    
    @GetMapping("/games")
    public List<Game> getGames() {
    	return (List<Game>) gameRepository.findAll();
    }
    
    @GetMapping("/games/{id}")
    public Game getGameById(@PathVariable String id) {
    	   	
    	Optional <Game> game = gameRepository.findById(Long.valueOf(id));
    	
    	if (game.isPresent()) {
    		return game.get();
    	} else {
    		return null;
    	}
    }
    
    @PostMapping("/addGame")
    public ResponseEntity<Game> setGame(@RequestBody Game game) {
    	this.gameRepository.save(game);
    	return new ResponseEntity<Game>(game, HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/games/{id}/togglestatus") 
    public ResponseEntity<Game> toggle(@PathVariable String id) {
    	Optional<Game> game = gameRepository.findById(Long.valueOf(id));
    	if (game.isPresent()) {
    		Game.Status oldStatus = game.get().getStatus();	
    		game.get().setStatus(oldStatus.toggle());
    		
    		gameRepository.save(game.get());
    		
    		return new ResponseEntity<Game>(game.get(), HttpStatus.ACCEPTED);
    	}
    	return new ResponseEntity<Game>(game.get(), HttpStatus.BAD_REQUEST);
    }
    
    @PostMapping("/games/{id}/checkin")
    public ResponseEntity<History> checkin(@PathVariable String id, @RequestBody User user) {
    	Optional<Game> game = gameRepository.findById(Long.valueOf(id));
    	if (game.isPresent()) {
    		Game.Status oldStatus = game.get().getStatus();	
    		if (game.get().getStatus().equals(Game.Status.OUT)) {
    			game.get().setStatus(oldStatus.toggle());
        		gameRepository.save(game.get());
        		History history = new History(Action.CHECKIN, user, game.get(), LocalDateTime.now());
        		historyRepository.save(history);
        		return new ResponseEntity<History>(history, HttpStatus.ACCEPTED);
    		}
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
    	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @PostMapping("/games/{id}/checkout")
    public ResponseEntity<History> checkout(@PathVariable String id, @RequestBody User user) {
    	Optional<Game> game = gameRepository.findById(Long.valueOf(id));
    	if (game.isPresent()) {
    		Game.Status oldStatus = game.get().getStatus();	
    		if (game.get().getStatus().equals(Game.Status.AVAILABLE)) {
    			game.get().setStatus(oldStatus.toggle());
        		gameRepository.save(game.get());
        		History history = new History(Action.CHECKOUT, user, game.get(), LocalDateTime.now());
        		historyRepository.save(history);
        		return new ResponseEntity<History>(history, HttpStatus.ACCEPTED);
    		}
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
    	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping("/games/{id}/status") 
    public ResponseEntity<Game.Status> getStatus(@PathVariable String id) {
    	Optional<Game> game = gameRepository.findById(Long.valueOf(id));
    	
    	if (game.isPresent()) {
    		return new ResponseEntity<Game.Status>(game.get().getStatus(), HttpStatus.OK);
    	}
    	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
	@GetMapping("/games/reload")
	public ResponseEntity<List<Game>> reload() {
		gameRepository.deleteAll();

		Game dominion = new Game("Dominion", 2, 4, 30, 13, "Medium Light", "Donald X. Vaccarino", "Rio Grande Games",
				"2008", "7.6", Game.Status.AVAILABLE, LocalDateTime.now(), LocalDateTime.now());
		Game starRealms = new Game("Star Realms", 2, 4, 20, 12, "Medium Light", "Robert Dougherty, Darwin Kastle",
				"White Wizard Games", "2014", "7.6", Game.Status.OUT, LocalDateTime.now(), LocalDateTime.now());
		Game catan = new Game("Settlers of Catan", 3, 4, 60, 13, "Medium Light", "Klaus Teuber", "KOSMOS", "1998",
				"7.2", Game.Status.AVAILABLE, LocalDateTime.now(), LocalDateTime.now());
		Game carcassonne = new Game("Carcassonne", 2, 5, 30, 13, "Medium Light", "Klaus-Jürgen Wrede", "Hans im Glück",
				"2000", "7.4", Game.Status.AVAILABLE, LocalDateTime.now(), LocalDateTime.now());
		Game kingOfTokyo = new Game("King of Tokyo", 2, 5, 45, 13, "Light", "Richard Garfield", "IELLO", "2011", "7.2",
				Game.Status.OUT, LocalDateTime.now(), LocalDateTime.now());

		List<Game> games = Arrays.asList(dominion, starRealms, catan, carcassonne, kingOfTokyo);

		gameRepository.saveAll(games);

		return new ResponseEntity<List<Game>>(games, HttpStatus.ACCEPTED);
	}
}
