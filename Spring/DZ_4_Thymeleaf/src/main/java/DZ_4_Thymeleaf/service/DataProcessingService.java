package DZ_4_Thymeleaf.service;

import DZ_4_Thymeleaf.model.User;
import DZ_4_Thymeleaf.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DataProcessingService {
    private final UserRepository userRepository;

    public List<User> sortUsersByAge() {
        return userRepository.findAll().stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .collect(Collectors.toList());
    }

    public List<User> filterUsersByAge(int age) {
        return userRepository.findAll().stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    public double calculateAverageAge() {
        return userRepository.findAll().stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }
}