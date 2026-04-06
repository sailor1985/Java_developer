package DZ_4_Thymeleaf.api;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import DZ_4_Thymeleaf.model.Issue;
import DZ_4_Thymeleaf.service.IssueService;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/issues")
@RequiredArgsConstructor
@Slf4j
public class IssueController {

    private final IssueService issueService;

    //найти в репозитории выдачу и проставить ей returned_at
    @PutMapping("/issue/{issueId}")
    public ResponseEntity<Void> returnBook(@PathVariable long issueId) {
        issueService.returnBook(issueId);
        return ResponseEntity.noContent().build(); // Вернет статус 204 (Успешно, без контента)
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

    @GetMapping("/ui/issues")
    public String getAllIssues(Model model) {
        log.info("Запрос на получение всех запросов выдачи");
        model.addAttribute("issues", issueService.getAllIssues());
        return  "issuesTable";
    }

    @GetMapping("/ui/issues/{id}")
    public String getIssue(@PathVariable long id,  Model model) {
        Issue issue = issueService.getIssueById(id);
        model.addAttribute("issue", issue);
        return  "issuesTable";
    }
}

