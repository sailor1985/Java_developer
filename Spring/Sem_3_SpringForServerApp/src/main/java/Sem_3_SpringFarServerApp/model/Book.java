package Sem_3_SpringFarServerApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    public static long sequence = 1L;
    private long id;
    private  String name;

    public Book(String name) {
        this(sequence++,name);
    }
}
