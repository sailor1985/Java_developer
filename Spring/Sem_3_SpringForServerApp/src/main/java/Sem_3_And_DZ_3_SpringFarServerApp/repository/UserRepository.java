package Sem_3_And_DZ_3_SpringFarServerApp.repository;

import Sem_3_And_DZ_3_SpringFarServerApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Больше ничего писать не нужно, методы save() и findAll() уже есть внутри
}