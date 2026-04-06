package DZ_4_Thymeleaf.service;

import DZ_4_Thymeleaf.model.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notifyUser(User user) {
        System.out.println("Новый пользователь зарегистрирован: " + user.getName());
    }
}