package Sem_3_And_DZ_3_SpringFarServerApp.repository;

import org.springframework.stereotype.Repository;
import Sem_3_And_DZ_3_SpringFarServerApp.model.Issue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class IssueRepository {
    private final List<Issue> issues;

    public IssueRepository() {
        this.issues = new ArrayList<>();
    }

    public void save(Issue issue) {
        issues.add(issue);
    }

    public List<Issue> getAllIssues() {
        return List.copyOf(issues); // возвращаем копию списка
    }

    public Issue getIssueById(long id) {
        return issues.stream().filter(it-> Objects.equals(it.getId(),id)).
                findFirst().orElse(null);
    }

    // Метод для поиска выдачи по читателю
    public Issue findByReaderId(long readerId) {
        return issues.stream()
                .filter(it -> it.getReaderId() == readerId)
                .findFirst()
                .orElse(null);
    }

    // Все выдачи конкретного Reader
    public List<Issue> findAllByReaderId(long readerId) {
        return issues.stream()
                .filter(it -> it.getReaderId() == readerId)
                .toList(); // Собираем ВСЕ совпадения в список
    }

    public void returnBook(long issueId) {
        issues.stream()
                .filter(it -> it.getId() == issueId)
                .findFirst().ifPresent(issue -> issue.setReturned_at(LocalDateTime.now()));

    }
}
