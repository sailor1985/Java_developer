package DZ_4_Thymeleaf.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import DZ_4_Thymeleaf.model.Book;
import DZ_4_Thymeleaf.service.BookService;

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
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return  "booksTable";
    }
}