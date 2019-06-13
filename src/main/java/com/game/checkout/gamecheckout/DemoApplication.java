package com.game.checkout.gamecheckout;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import com.game.checkout.gamecheckout.domain.Game;
import com.game.checkout.gamecheckout.domain.User;
import com.game.checkout.gamecheckout.repository.GameRepository;
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
    CommandLineRunner init(UserRepository userRepository, GameRepository gameRepository) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                User user = new User(name,name + "@domain.com", LocalDateTime.now(), LocalDateTime.now());
                userRepository.save(user);
            });
            userRepository.findAll().forEach(p -> System.out.println(p));
            
            Game dominion = new Game("Dominion", 2, 4, 30, 13, "Medium Light", "Donald X. Vaccarino", "Rio Grande Games", "2008", "7.6", Game.Status.AVAILABLE, LocalDateTime.now(), LocalDateTime.now());
            Game starRealms = new Game("Star Realms", 2, 4, 20, 12, "Medium Light", "Robert Dougherty, Darwin Kastle", "White Wizard Games", "2014", "7.6", Game.Status.OUT, LocalDateTime.now(), LocalDateTime.now());
            Game catan = new Game("Settlers of Catan", 3, 4, 60, 13, "Medium Light", "Klaus Teuber", "KOSMOS", "1998", "7.2", Game.Status.AVAILABLE, LocalDateTime.now(), LocalDateTime.now());
            Game carcassonne = new Game("Carcassonne", 2, 5, 30, 13, "Medium Light", "Klaus-Jürgen Wrede", "Hans im Glück", "2000", "7.4", Game.Status.AVAILABLE, LocalDateTime.now(), LocalDateTime.now());
            Game kingOfTokyo = new Game("King of Tokyo", 2, 5, 45, 13, "Light", "Richard Garfield", "IELLO", "2011", "7.2", Game.Status.OUT, LocalDateTime.now(), LocalDateTime.now());
            
            
            gameRepository.save(dominion);
            gameRepository.save(starRealms);
            gameRepository.save(catan);
            gameRepository.save(carcassonne);
            gameRepository.save(kingOfTokyo);
            
            gameRepository.findAll().forEach(g -> System.out.println(g));
        };
        
    }
}
