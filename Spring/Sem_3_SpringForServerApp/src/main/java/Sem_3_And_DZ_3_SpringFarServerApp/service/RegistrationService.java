package Sem_3_And_DZ_3_SpringFarServerApp.service;

import Sem_3_And_DZ_3_SpringFarServerApp.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final UserService userService;
    private final NotificationService notificationService;

    public User processRegistration(String name, int age, String email) {
        User newUser = new User();
        newUser.setName(name);
        newUser.setAge(age);
        newUser.setEmail(email);

        User savedUser = userService.saveUser(newUser);
        notificationService.notifyUser(savedUser);

        return savedUser;
    }
}