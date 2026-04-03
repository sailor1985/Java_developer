package Sem_3_And_DZ_3_SpringFarServerApp.api;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Sem_3_And_DZ_3_SpringFarServerApp.model.Issue;
import Sem_3_And_DZ_3_SpringFarServerApp.model.Reader;
import Sem_3_And_DZ_3_SpringFarServerApp.service.ReaderService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/readers")
@RequiredArgsConstructor
@Slf4j
public class ReaderController {

    private final ReaderService readerService;

    @GetMapping
    public ResponseEntity<List<Reader>> getAllReaders() {
        log.info("Запрос на получение всех читателей");
        return ResponseEntity.ok(readerService.getAllReaders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reader> getReader(@PathVariable long id) {
        Reader reader = readerService.getReaderById(id);

        if (reader != null) {
            return ResponseEntity.ok(reader);// Если нашли — возвращаем статус 200 OK и самого читателя
        } else {
            return ResponseEntity.notFound().build(); // Если не нашли — возвращаем статус 404 Not Found
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReader(@PathVariable long id) {
        boolean deletedReaderById = readerService.deleteReaderById(id);

        if (deletedReaderById) {
            return ResponseEntity.noContent().build();// 204 No Content — успех, тела нет
        } else {
            return ResponseEntity.notFound().build(); // // 404 Not Found — если книги с таким ID не было
        }
    }

    @PostMapping
    public ResponseEntity<Reader> createReader(@RequestBody Reader reader) {
        Reader createdReader = readerService.addReader(reader.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReader);// Возвращаем статус 201 и саму книгу в формате JSON
    }


    @GetMapping("/{id}/issue")
    public ResponseEntity<List<Issue>> getReaderIssues(@PathVariable long id) {
        try {
            List<Issue> issues = readerService.getIssuesByReaderId(id);
            return ResponseEntity.ok(issues);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}