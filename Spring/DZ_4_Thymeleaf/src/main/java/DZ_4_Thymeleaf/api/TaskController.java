package DZ_4_Thymeleaf.api;

import DZ_4_Thymeleaf.model.User;
import DZ_4_Thymeleaf.service.DataProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final DataProcessingService dataProcessingService;

    @GetMapping("/sort")
    public List<User> sortUsers() {
        return dataProcessingService.sortUsersByAge();
    }

    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable int age) {
        return dataProcessingService.filterUsersByAge(age);
    }

    @GetMapping("/calc")
    public Double calculateAverageAge() {
        return dataProcessingService.calculateAverageAge();
    }
}