package com.game.checkout.gamecheckout.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author alouden
 * Configuration for Password Encoder
 * 
 */

@Configuration
public class PasswordEncoderConfig {

    //Use BCrypt hashing
    //TODO: Figure out how to upgrade to Argon2?  Currently popular hasher in the industry
    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
}