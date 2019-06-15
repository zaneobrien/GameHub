package com.game.checkout.gamecheckout.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.game.checkout.gamecheckout.domain.User;

import com.game.checkout.gamecheckout.domain.History;
import com.game.checkout.gamecheckout.repository.HistoryRepository;

public class HistoryService {

	private HistoryRepository repo;
	
	HistoryService(HistoryRepository repo) {
		this.repo = repo;
	}
	
	
}
