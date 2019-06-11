package com.game.checkout.gamecheckout.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.game.checkout.gamecheckout.repository.HistoryRepository;

@RestController
// TODO: figure out how to add the server.address here to the CrossOrigin
@CrossOrigin(origins = "http://localhost:4200")
public class HistoryController {
	
	private final HistoryRepository historyRepository;
	
	public HistoryController(HistoryRepository historyRepository) {
		this.historyRepository = historyRepository;
	}

}
