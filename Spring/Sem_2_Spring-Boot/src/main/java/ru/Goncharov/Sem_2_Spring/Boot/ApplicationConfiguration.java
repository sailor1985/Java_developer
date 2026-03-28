package ru.Goncharov.Sem_2_Spring.Boot;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ApplicationConfiguration {

    @Bean
    UserRepository myUserRepository () {
       return new UserRepository();
    }


}
