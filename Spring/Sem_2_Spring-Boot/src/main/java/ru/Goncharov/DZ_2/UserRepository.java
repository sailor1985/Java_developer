package ru.Goncharov.DZ_2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Все методы CRUD (Save, Delete, Find) уже созданы "под капотом"
    Optional<User> findByName(String name);
}