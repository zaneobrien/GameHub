package com.game.checkout.gamecheckout.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.game.checkout.gamecheckout.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{}