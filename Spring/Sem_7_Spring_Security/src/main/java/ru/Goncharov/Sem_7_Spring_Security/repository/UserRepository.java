package ru.Goncharov.Sem_7_Spring_Security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.Goncharov.Sem_7_Spring_Security.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
}
