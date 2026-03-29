package ru.Goncharov.Sem_2_Spring;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class UserRepository {

    private List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
        users.add(new User("Igor"));
        users.add(new User("User #2"));
        users.add(new User("User #3"));
        users.add(new User("User #4"));
        users.add(new User("User #5"));
    }

    public List<User> getAll() {
        return List.copyOf(users);
    }

    public User getById(long id){
        return users.stream().filter(user -> Objects.equals(user.getId(),id)).findFirst().orElse(null);
    }

    public User getByName(String name) {
        return users.stream().filter(user -> Objects.equals(user.getName(),name)).findFirst().orElse(null);
    }


}