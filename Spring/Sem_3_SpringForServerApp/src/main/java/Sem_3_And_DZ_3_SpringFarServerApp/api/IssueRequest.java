package Sem_3_And_DZ_3_SpringFarServerApp.api;

import lombok.Data;

/*
Запрос на выдачу
 */
@Data
public class IssueRequest {
    /*
    Идентификатор читателя
     */
    private long readerId;

    /*
    Идентификатор книги
    */
    private long bookId;

}
