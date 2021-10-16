package io.sh.streak.user;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User samir = new User("Samir", "SamirHaque@gmail.com", 0, false, LocalDate.now());
            repository.saveAll(List.of(samir));
        };

    }
}
