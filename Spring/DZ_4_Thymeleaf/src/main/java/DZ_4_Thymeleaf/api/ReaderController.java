package DZ_4_Thymeleaf.api;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import DZ_4_Thymeleaf.model.Issue;
import DZ_4_Thymeleaf.model.Reader;
import DZ_4_Thymeleaf.service.ReaderService;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/readers")
@RequiredArgsConstructor
@Slf4j
public class ReaderController {

    private final ReaderService readerService;

    @GetMapping("/ui/readers")
    public String getAllReaders(Model model) {
        log.info("Запрос на получение всех читателей");
        model.addAttribute("readers", readerService.getAllReaders());
        return "readersTable";
    }

    @GetMapping("/ui/readers/{id}")
    public String getReader(@PathVariable long id, Model model) {
        Reader reader = readerService.getReaderById(id);
        model.addAttribute("reader", reader);
        return "readersTable";
    }

    @GetMapping("/ui/reader/{id}")
    public String getReaderIssues(@PathVariable long id, Model model) {
        List<Issue> issues = readerService.getIssuesByReaderId(id);
        model.addAttribute("issuesReader", issues);
        return "issuesTable";
    }
}