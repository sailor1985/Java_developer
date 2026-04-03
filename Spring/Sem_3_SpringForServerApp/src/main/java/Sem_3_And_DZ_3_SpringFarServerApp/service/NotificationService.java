package Sem_3_And_DZ_3_SpringFarServerApp.service;

import Sem_3_And_DZ_3_SpringFarServerApp.model.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notifyUser(User user) {
        System.out.println("Новый пользователь зарегистрирован: " + user.getName());
    }
}