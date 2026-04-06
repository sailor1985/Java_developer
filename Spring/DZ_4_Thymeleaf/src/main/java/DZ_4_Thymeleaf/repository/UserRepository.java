package DZ_4_Thymeleaf.repository;

import DZ_4_Thymeleaf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Больше ничего писать не нужно, методы save() и findAll() уже есть внутри
}