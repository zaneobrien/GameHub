package com.game.checkout.gamecheckout.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.checkout.gamecheckout.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public List <User> findAllByName(String name);
	
	// black magic reflection happening here
	public Stream <User> findAllByEmail(String something);

	public User findByEmail(String email);
}