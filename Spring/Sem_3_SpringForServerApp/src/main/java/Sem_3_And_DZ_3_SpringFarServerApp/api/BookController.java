package Sem_3_And_DZ_3_SpringFarServerApp.api;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Sem_3_And_DZ_3_SpringFarServerApp.model.Book;
import Sem_3_And_DZ_3_SpringFarServerApp.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        log.info("Запрос на получение всех книг");
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable long id) {
        Book book = bookService.getBookById(id);

        if (book != null) {
            return ResponseEntity.ok(book);// Если нашли — возвращаем статус 200 OK и саму книгу
        } else {
            return ResponseEntity.notFound().build(); // Если не нашли — возвращаем статус 404 Not Found
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable long id) {
        boolean deletedBookById = bookService.deleteBookById(id);

        if (deletedBookById) {
            return ResponseEntity.noContent().build();// 204 No Content — успех, тела нет
        } else {
            return ResponseEntity.notFound().build(); // // 404 Not Found — если книги с таким ID не было
        }
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = bookService.addBook(book.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);// Возвращаем статус 201 и саму книгу в формате JSON
    }
}