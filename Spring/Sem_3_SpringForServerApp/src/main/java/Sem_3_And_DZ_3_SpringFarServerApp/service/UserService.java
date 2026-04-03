package Sem_3_And_DZ_3_SpringFarServerApp.service;

import Sem_3_And_DZ_3_SpringFarServerApp.model.User;
import Sem_3_And_DZ_3_SpringFarServerApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}