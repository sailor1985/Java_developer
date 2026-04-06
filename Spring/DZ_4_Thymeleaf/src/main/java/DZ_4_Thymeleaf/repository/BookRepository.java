package DZ_4_Thymeleaf.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import DZ_4_Thymeleaf.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class BookRepository {
    private final List<Book> books;

    public BookRepository() {
        this.books = new ArrayList<>();
    }

    @PostConstruct
    public void generateData() {
        books.addAll(List.of(
                new Book("Война и мир"),
                new Book("Мертвые души"),
                new Book("Чистый код")
        ));
    }

    public List<Book> getAllBooks() {
        return List.copyOf(books); // возвращаем копию списка
    }

    public Book getBookById(long id) {
        return books.stream().filter(it->Objects.equals(it.getId(),id)).
                findFirst().orElse(null);
    }

    public boolean deleteBookById(long id) {
        return books.removeIf(book ->Objects.equals(book.getId(),id));
    }

    public Book addBook(String name) {
        Book book = new Book(name);
        books.add(book);
        return book;
    }
}
