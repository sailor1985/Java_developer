package DZ_6_DesignAPIForServerApp.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

//Полная информация о конкретной заметке
@Data
public class NoteDetailedDTO {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
    private Long userId;
    private List<String> tags;
}
