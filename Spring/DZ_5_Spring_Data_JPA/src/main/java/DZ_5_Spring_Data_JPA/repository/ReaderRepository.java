package DZ_5_Spring_Data_JPA.repository;

import DZ_5_Spring_Data_JPA.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReaderRepository extends JpaRepository<Reader, Long> {
}