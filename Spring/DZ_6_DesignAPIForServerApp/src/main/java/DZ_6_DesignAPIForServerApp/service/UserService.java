package DZ_6_DesignAPIForServerApp.service;

import DZ_6_DesignAPIForServerApp.model.User;
import DZ_6_DesignAPIForServerApp.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    // Создание пользователя
    public User createUser(User user) {
        return repository.save(user);
    }

    // Получить всех пользователей
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    // Найти одного пользователя
    public Optional<User> findUserById(Long userId) {
        return repository.findById(userId);
    }

    // Обновление данных пользователя
    @Transactional
    public User updateUser(Long id, String newName, Integer newAge) {
        User person = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Пользователь с ID " + id + " не найден"));

        person.setName(newName);
        person.setAge(newAge);
        return repository.save(person);
    }

    // Удаление пользователя
    public void deleteUser(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Невозможно удалить: пользователь с ID " + id + " не найден");
        }
        repository.deleteById(id);
    }
}