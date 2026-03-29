package ru.Goncharov.DZ_2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static ru.Goncharov.DZ_2.User.random;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUsers() {
        List<User> users = new ArrayList<>();
        int count = random.nextInt(5,11);

        for (int i = 0; i < count; i++) {
            users.add(User.create());
        }
        userRepository.saveAll(users); // Используем встроенный метод saveAll
    }

    // Найти по ID
    public User getById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    // Найти по имени
    public User getByName(String name) {
        return userRepository.findByName(name).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user); // save работает и на создание, и на обновление
    }

    // Удаление по id
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    // Получение одного
    public User getOne(int id) {
        return userRepository.findById(id).orElse(null);
    }

    // Обновление
    public User update(User user) {
        return userRepository.save(user);
    }

    public void saveUsers(List<User> users) {
        userRepository.saveAll(users);
    }

}