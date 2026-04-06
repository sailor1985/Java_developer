package DZ_4_Thymeleaf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import DZ_4_Thymeleaf.model.Book;
import DZ_4_Thymeleaf.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public Book getBookById(long id) {
        return bookRepository.getBookById(id);
    }

    public boolean deleteBookById(long id) {
        return bookRepository.deleteBookById(id);
    }

    public Book addBook(String name) {
        return bookRepository.addBook(name);
    }
}
