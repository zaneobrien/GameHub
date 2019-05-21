package com.game.checkout.gamecheckout.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.game.checkout.gamecheckout.domain.Game;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {}
