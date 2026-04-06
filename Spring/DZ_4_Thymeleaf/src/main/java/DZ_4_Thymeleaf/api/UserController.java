package DZ_4_Thymeleaf.api;

import DZ_4_Thymeleaf.model.User;
import DZ_4_Thymeleaf.service.RegistrationService;
import DZ_4_Thymeleaf.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final RegistrationService registrationService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Добавление через Body (JSON)
    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        registrationService.processRegistration(user.getName(), user.getAge(), user.getEmail());
        return "User added from body!";
    }

    // URL: http://localhost:8080/user/param?name=Artur&age=23&email=exam@mail.ru
    @PostMapping("/param")
    public String userAddFromParam(
            @RequestParam String name,
            @RequestParam int age,
            @RequestParam String email) {
        registrationService.processRegistration(name, age, email);
        return "User added from parameters!";
    }
}