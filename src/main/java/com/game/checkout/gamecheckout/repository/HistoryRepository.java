package com.game.checkout.gamecheckout.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.game.checkout.gamecheckout.domain.History;
import com.game.checkout.gamecheckout.domain.User;

public interface HistoryRepository extends CrudRepository<History, Long>, JpaSpecificationExecutor<User> {}