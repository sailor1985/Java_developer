package ru.Goncharov.Sem_5_Spring_Data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.Goncharov.Sem_5_Spring_Data.model.User;

import java.util.List;

//public interface UserRepository extends CrudRepository<User, Long> {
//
//}

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByName(String name);

}
