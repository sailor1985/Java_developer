package DZ_6_DesignAPIForServerApp.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

//Краткая информация о заметке для списка
@Data
public class NoteSummaryDTO {
    private Long id;
    private String title;
    private LocalDateTime createdAt;
    private List<Long> tags; // Здесь только ID
}
