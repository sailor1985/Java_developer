package DZ_5_Spring_Data_JPA.service;

import DZ_5_Spring_Data_JPA.api.IssueRequest;
import DZ_5_Spring_Data_JPA.model.Issue;
import DZ_5_Spring_Data_JPA.repository.BookRepository;
import DZ_5_Spring_Data_JPA.repository.IssueRepository;
import DZ_5_Spring_Data_JPA.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class IssueService {

    // Лимит книг из application.yml (например, 3)
    @Value("${application.max-allowed-books:3}")
    private int maxAllowedBooks;

    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;

    @Transactional
    public Issue createIssue(IssueRequest request) {
        // Проверка существования книги и читателя
        if (bookRepository.findById(request.getBookId()).isEmpty()) {
            throw new NoSuchElementException("Не найдена книга с ID: " + request.getBookId());
        }
        if (readerRepository.findById(request.getReaderId()).isEmpty()) {
            throw new NoSuchElementException("Не найден читатель с ID: " + request.getReaderId());
        }

        // Логика: проверяем, сколько книг уже на руках у читателя
        // Считаем только те записи, где returnedAt == null
        long count = issueRepository.findByReaderId(request.getReaderId()).stream()
                .filter(it -> it.getReturnedAt() == null)
                .count();

        if (count >= maxAllowedBooks) {
            throw new RuntimeException("Превышен лимит книг у читателя!");
        }

        Issue issue = new Issue(request.getBookId(), request.getReaderId());
        return issueRepository.save(issue);
    }

    public Issue getById(long id) {
        return issueRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public void returnBook(long issueId) {
        Issue issue = issueRepository.findById(issueId)
                .orElseThrow(() -> new NoSuchElementException("Запись о выдаче не найдена"));
        issue.setReturnedAt(LocalDateTime.now());
        issueRepository.save(issue);
    }

    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }
}