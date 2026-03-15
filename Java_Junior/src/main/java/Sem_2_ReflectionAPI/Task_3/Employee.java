package Sem_2_ReflectionAPI.Task_3;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class Employee {
    @Colomn(name = "id", primaryKey = true)
    private UUID uuid;

    @Colomn(name = "username")
    private String username;

    @Colomn(name = "email")
    private String email;

    public Employee(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
