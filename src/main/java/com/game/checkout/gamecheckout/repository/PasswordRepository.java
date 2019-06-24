package com.game.checkout.gamecheckout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.checkout.gamecheckout.domain.Password;
import com.game.checkout.gamecheckout.domain.User;

@Repository
public interface PasswordRepository extends JpaRepository<Password, Long>{
	public Password findByUser(User user);
}