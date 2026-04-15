package DZ_5_Spring_Data_JPA.service;

import DZ_5_Spring_Data_JPA.model.Book;
import DZ_5_Spring_Data_JPA.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getById(long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void delete(long id) {
        bookRepository.deleteById(id);
    }

    public Book create(String name) {
        return bookRepository.save(new Book(name));
    }
}