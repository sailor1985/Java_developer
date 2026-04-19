package DZ_6_DesignAPIForServerApp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "notes")
// Слушатель для автоматического заполнения @CreatedDate
@EntityListeners(AuditingEntityListener.class)
@Schema(name = "Заметка", description = "Сущность заметки с поддержкой тегов и авторов")
@NoArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Идентификатор заметки", example = "1")
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Заголовок заметки", example = "first")
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    @Schema(description = "Содержимое заметки", example = "content of note")
    private String content;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Schema(description = "Дата создания")
    private LocalDateTime createdAt;

    @Column(name = "deleted_at")
    @Schema(description = "Дата удаления (для корзины)", example = "null")
    private LocalDateTime deletedAt;

    @Column(name = "user_id")
    @Schema(description = "ID владельца заметки", example = "3")
    private Long userId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "note_tags", // Промежуточная таблица в БД
            joinColumns = @JoinColumn(name = "note_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @Schema(description = "Список привязанных тегов")
    private List<Tag> tags = new ArrayList<>();

    public Note(String title, String content, Long userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }
}