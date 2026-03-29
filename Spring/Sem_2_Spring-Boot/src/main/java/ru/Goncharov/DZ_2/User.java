package ru.Goncharov.DZ_2;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@JsonPropertyOrder({ "id", "name" })
public class User {

    private static final String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен"};
    static final Random random = new Random();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    public User(String name) {
        this.name = name;
    }

    public static User create() {
        return new User(names[random.nextInt(names.length)]);
    }
}