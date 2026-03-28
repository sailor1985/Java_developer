package ru.Goncharov.Sem_2_Spring.Boot;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/users")
//@RequiredArgsConstructor
public class UserController {
    //@Autowired
    private UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }


//    @Autowired
//    public void setRepository(UserRepository repository) {
//        this.repository = repository;
//    }

    //@RequestMapping(path = "/users",method = RequestMethod.GET)
    @GetMapping(("/all"))
    public List<User> getUsers () {
        //return List.of(new User("Igor"), new User("unknown"));
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
        if (existUser == null) { //404
            throw new IllegalArgumentException();
        }
        existUser.setName(user.getName());
        return existUser;
    }
}
