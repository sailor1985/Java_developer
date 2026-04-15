package DZ_5_Spring_Data_JPA.api;

import DZ_5_Spring_Data_JPA.model.Issue;
import DZ_5_Spring_Data_JPA.model.Reader;
import DZ_5_Spring_Data_JPA.service.ReaderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/readers")
@RequiredArgsConstructor
@Slf4j
public class ReaderController {

    private final ReaderService readerService;

    @GetMapping("/ui/readers")
    public String getAllReaders(Model model) {
        log.info("Запрос на получение всех читателей");
        model.addAttribute("readers", readerService.getAll());
        return "readersTable";
    }

    @GetMapping("/ui/readers/{id}")
    public String getReader(@PathVariable long id, Model model) {
        Reader reader = readerService.getById(id);
        model.addAttribute("reader", reader);
        return "readersTable";
    }

    @GetMapping("/ui/reader/{id}")
    public String getReaderIssues(@PathVariable long id, Model model) {
        List<Issue> issues = readerService.getIssuesByReader(id);
        model.addAttribute("issuesReader", issues);
        return "issuesTable";
    }
}