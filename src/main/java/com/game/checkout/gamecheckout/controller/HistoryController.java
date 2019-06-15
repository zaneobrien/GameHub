package com.game.checkout.gamecheckout.controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
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
import com.game.checkout.gamecheckout.domain.History;

import com.game.checkout.gamecheckout.repository.HistoryRepository;

@RestController
// TODO: figure out how to add the server.address here to the CrossOrigin
@CrossOrigin(origins = "http://localhost:4200")
public class HistoryController {
	
	private final HistoryRepository historyRepository;
	
	public HistoryController(HistoryRepository historyRepository) {
		this.historyRepository = historyRepository;
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

}
