package com.game.checkout.gamecheckout.repository;

import org.springframework.data.repository.CrudRepository;

import com.game.checkout.gamecheckout.domain.History;

public interface HistoryRepository extends CrudRepository<History, Long> {}