package Sem_3_SpringFarServerApp.api;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Sem_3_SpringFarServerApp.model.Issue;
import Sem_3_SpringFarServerApp.service.IssueService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/issues")
@RequiredArgsConstructor
@Slf4j
public class IssueController {

    private final IssueService issueService;

    @PutMapping("/issue/{issueId}")
    public void returnBook(@PathVariable long issueId) {//найти в репозитории выдачу и проставить ей returned_at
        issueService.returnBook(issueId);
    }

    @PostMapping
    public ResponseEntity<Issue> issueBook(@RequestBody IssueRequest request) {
        log.info("Получен запрос на выдачу: readerId = {}, bookId = {}",request.getReaderId(), request.getBookId());
        final Issue issue;

        try {
            issue = issueService.issue(request);
        } catch (NoSuchElementException e) {
            // Если ресурса нет (книги или читателя) — 404 Not Found
            log.error("Ошибка при выдаче: {}", e.getMessage());
            return  ResponseEntity.notFound().build();
        } catch (IllegalStateException e) {
            // Если (книга уже есть) — 409 Conflict
            log.error("Конфликт при выдаче: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(issue);
    }

    @GetMapping
    public ResponseEntity<List<Issue>> getAllIssues() {
        log.info("Запрос на получение всех запросов выдачи");
        return ResponseEntity.ok(issueService.getAllIssues());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Issue> getIssue(@PathVariable long id) {
        Issue issue = issueService.getIssueById(id);

        if (issue != null) {
            return ResponseEntity.ok(issue);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

