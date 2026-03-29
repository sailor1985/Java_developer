package ru.Goncharov.DZ_2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getUsers() {
        List<User> users = userService.findAll();

        if (users.isEmpty()) { // Если в базе никого нет — создаем начальный список
            userService.createUsers();
            return userService.findAll(); // Возвращаем уже наполненный список
        }
        return users;
    }

    // Получение по ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getById(id);
    }

    // Получение по имени
    // http://localhost:8080/users/search?name=Глеб
    @GetMapping("/search")
    public User getUserByName(@RequestParam String name) {
        return userService.getByName(name);
    }

    // Удаление по ID
    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteById(id);
        return "User with ID " + id + " deleted successfully. Go back to /users";
    }

    // Получить данные о пользователе по id
    @GetMapping("/user-update/{id}")
    public User getUserForUpdate(@PathVariable int id) {
        return userService.getOne(id);
    }

    // Обновить пользователя
    @PostMapping("/user-update")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
}