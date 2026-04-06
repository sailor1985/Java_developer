package DZ_4_Thymeleaf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import DZ_4_Thymeleaf.api.IssueRequest;
import DZ_4_Thymeleaf.model.Issue;
import DZ_4_Thymeleaf.repository.BookRepository;
import DZ_4_Thymeleaf.repository.IssueRepository;
import DZ_4_Thymeleaf.repository.ReaderRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class IssueService {
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;

    public Issue issue(IssueRequest request) {
        if (bookRepository.getBookById(request.getBookId()) == null) {
            throw new NoSuchElementException("Не найдена книга с идентификатором \"" + request.getBookId() + "\"");
        }
        if (readerRepository.getReaderById(request.getReaderId()) == null) {
            throw new NoSuchElementException("Не найден читатель с идентификатором \"" + request.getReaderId() + "\"");
        }
        // Проверка, нет ли у читателя уже книги на руках?
        if (issueRepository.findByReaderId(request.getReaderId()) != null) {
            throw new IllegalStateException("У читателя с ID " + request.getReaderId() + " уже есть книга");
        }

        // Если всё Ок — создаем и сохраняем выдачу
        Issue issue = new Issue(request.getBookId(), request.getReaderId());
        issueRepository.save(issue);
        return issue;
    }

    public List<Issue> getAllIssues() {
        return issueRepository.getAllIssues();
    }

    public Issue getIssueById(long id) {
        return issueRepository.getIssueById(id);
    }

    public void returnBook(long issueId) {
        issueRepository.returnBook(issueId);
    }


}
