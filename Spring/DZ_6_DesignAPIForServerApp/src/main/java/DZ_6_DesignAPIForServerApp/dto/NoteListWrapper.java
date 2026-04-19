package DZ_6_DesignAPIForServerApp.dto; // Убедитесь, что пакет правильный

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


//"Главная коробка" для ответа на запрос списка заметок
@Data
@AllArgsConstructor // Этот файл ОБЯЗАТЕЛЬНО должен быть здесь
@NoArgsConstructor
public class NoteListWrapper {
    private List<NoteSummaryDTO> notes; // Тип должен совпадать с dtos
    private PagingResponse paging;
}