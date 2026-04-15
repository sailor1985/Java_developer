package DZ_5_Spring_Data_JPA.api;

import DZ_5_Spring_Data_JPA.model.Issue;
import DZ_5_Spring_Data_JPA.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/issue")
@RequiredArgsConstructor
public class IssueController {

    private final IssueService service;

    @GetMapping
    public ResponseEntity<List<Issue>> getAllIssues() {
        return ResponseEntity.ok(service.getAllIssues());
    }

    @PostMapping
    public ResponseEntity<Issue> issueBook(@RequestBody IssueRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.createIssue(request));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Issue> getById(@PathVariable long id) {
        try {
            return ResponseEntity.ok(service.getById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}") // Метод для возврата книги
    public void returnBook(@PathVariable long id) {
        service.returnBook(id);
    }
}