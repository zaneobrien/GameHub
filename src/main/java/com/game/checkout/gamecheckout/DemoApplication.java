package com.game.checkout.gamecheckout;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import com.game.checkout.gamecheckout.domain.User;
import com.game.checkout.gamecheckout.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                User user = new User(name,name + "@domain.com","Passwordhere", LocalDateTime.now(), LocalDateTime.now());
                userRepository.save(user);
            });
            userRepository.findAll().forEach(p -> System.out.println(p));
        };
    }
}
