package DZ_6_DesignAPIForServerApp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tags")
@Data
@NoArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String color;
    private String description;
    private Long userId; // Тэг принадлежит пользователю

    public Tag(String title, String color, String description, Long userId) {
        this.title = title;
        this.color = color;
        this.description = description;
        this.userId = userId;
    }
}
