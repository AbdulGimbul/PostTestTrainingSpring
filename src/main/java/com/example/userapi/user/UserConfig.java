package com.example.userapi.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            UserRepository repository
    ){
        return args -> {
            User abdl = new User();
            abdl.setId(1L);
            abdl.setUsername("abdl");
            abdl.setPassword("00000");
            abdl.setIs_active(1);

            User alex = new User();
            alex.setId(2L);
            alex.setUsername("alex");
            alex.setPassword("123456");
            alex.setIs_active(1);

            repository.saveAll(List.of(abdl, alex));
        };
    }
}
