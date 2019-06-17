package com.game.checkout.gamecheckout.controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
import com.game.checkout.gamecheckout.domain.User;
import com.game.checkout.gamecheckout.repository.GameRepository;
import com.game.checkout.gamecheckout.repository.HistoryRepository;
import com.game.checkout.gamecheckout.repository.UserRepository;
import com.game.checkout.gamecheckout.service.HistoryService;

@RestController
// TODO: figure out how to add the server.address here to the CrossOrigin
@CrossOrigin(origins = "http://localhost:4200")
public class HistoryController {
	
	private final HistoryRepository historyRepository;
	
	private final HistoryService historyService;
	
	private final UserRepository userRepository;
	
	private final GameRepository gameRepository;
	
	public HistoryController(HistoryRepository historyRepository,
                             HistoryService historyService, 
                             UserRepository userRepository,
                             GameRepository gameRepository) {
		this.historyRepository = historyRepository;
		this.historyService = historyService;
		this.userRepository = userRepository;
		this.gameRepository = gameRepository;
	}
	
	@GetMapping("/history")
	public ResponseEntity<List <History>> findAll() {
		List <History> histories = (List <History>) historyRepository.findAll();
		return new ResponseEntity<List<History>>(histories, HttpStatus.OK);
	}
	
	@GetMapping("/history/{id}")
	public List <History> findAllById(@PathVariable Long id) {
		return (List<History>) historyRepository.findAllById(Arrays.asList(id));
	}
	
	@PostMapping("/history")
	public void setHistory(@RequestBody History history) {
		this.historyRepository.save(history);
	}
	
	@GetMapping("/history/user/{id}")
	public ResponseEntity<List <History>> findAllByUserId(@PathVariable String id) {
		
		Optional<User> user = userRepository.findById(Long.valueOf(id));
		
		if (user.isPresent()) {
			List <History> history = this.historyService.getHistoryByUser(user.get());
			return new ResponseEntity<List<History>>(history, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping("/history/game/{id}")
	public ResponseEntity<List <History>> findAllByGameId(@PathVariable String id) {
		
		Optional<Game> game = gameRepository.findById(Long.valueOf(id));
		
		if (game.isPresent()) {
			List <History> history = this.historyService.getHistoryByGame(game.get());
			return new ResponseEntity<List<History>>(history, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}

}
