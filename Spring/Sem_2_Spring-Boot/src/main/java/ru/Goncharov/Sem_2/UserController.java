package ru.Goncharov.Sem_2_Spring;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping(("/all"))
    public List<User> getUsers () {
        return repository.getAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) {
        return repository.getById(id);
    }

    @GetMapping
    public User getUserByName(@RequestParam String name) {
        return repository.getByName(name);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User user) {
        User existUser = repository.getById(id);
        if (existUser == null) {
            throw new IllegalArgumentException();
        }
        existUser.setName(user.getName());
        return existUser;
    }
}