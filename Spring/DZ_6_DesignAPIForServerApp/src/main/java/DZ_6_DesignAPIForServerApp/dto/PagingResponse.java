package DZ_6_DesignAPIForServerApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


//Для описания страниц
@Data
@AllArgsConstructor
public class PagingResponse {
    private int page;//Номер текущей страницы
    private int size;//Сколько заметок на одной странице
    private long total;//Сколько всего заметок в базе
    private int totalPages; //Сколько всего страниц получилось
}
