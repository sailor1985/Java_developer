package DZ_6_DesignAPIForServerApp.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@Schema(name = "Пользователь")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "Идентификатор пользователя")
    private Long id;

    @Column(name = "name")
    @Schema(name = "Имя пользователя")
    private String name;

    @Column(name = "age")
    @Schema(name = "Возраст пользователя", minimum = "0", maximum = "100")
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}