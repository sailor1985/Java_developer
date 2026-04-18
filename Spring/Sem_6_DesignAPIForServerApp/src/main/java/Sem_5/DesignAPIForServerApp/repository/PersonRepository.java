package Sem_5.DesignAPIForServerApp.repository;

import Sem_5.DesignAPIForServerApp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
