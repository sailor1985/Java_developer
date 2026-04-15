package DZ_5_Spring_Data_JPA.repository;

import DZ_5_Spring_Data_JPA.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IssueRepository extends JpaRepository<Issue, Long> {
    List<Issue> findByReaderId(Long readerId);
}