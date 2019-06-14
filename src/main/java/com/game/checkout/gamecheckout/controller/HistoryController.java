package com.game.checkout.gamecheckout.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
	public List <History> findAll() {
		return (List <History>) historyRepository.findAll();
	}
	
	@GetMapping("/history/user/{id}")
	public List <History> findAllById(@PathVariable Long id) {
		return findAll().stream().filter(h -> h.getUser().getUserId() == id).collect(Collectors.toList());
	}
	
	@PostMapping("/history")
	public void setHistory(@RequestBody History history) {
		this.historyRepository.save(history);
	}

}
