package DZ_5_Spring_Data_JPA.api;

import DZ_5_Spring_Data_JPA.model.Book;
import DZ_5_Spring_Data_JPA.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookService bookService;

    @GetMapping("/ui/books")
    public String getAllBooksUI(Model model) {
        log.info("Запрос на получение всех книг");
        model.addAttribute("books", bookService.getAllBooks());
        return "booksTable";
    }

    @GetMapping("/ui/books/{id}")
    public String getBook(@PathVariable long id, Model model) {
        Book book = bookService.getById(id);
        model.addAttribute("book", book);
        return  "booksTable";
    }
}