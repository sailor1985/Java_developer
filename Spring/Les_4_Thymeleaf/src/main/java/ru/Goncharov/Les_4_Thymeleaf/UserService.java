package ru.Goncharov.Les_4_Thymeleaf;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        userRepository.save(new User(null, "Алексей", "123@mail.ru"));
        userRepository.save(new User(null, "Виктор", "321@mail.ru"));
        userRepository.save(new User(null, "Сергей", "446@mail.ru"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id);
    }
}
