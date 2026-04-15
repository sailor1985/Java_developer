package DZ_5_Spring_Data_JPA.repository;

import DZ_5_Spring_Data_JPA.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {
}