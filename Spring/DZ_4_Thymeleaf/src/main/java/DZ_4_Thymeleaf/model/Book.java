package DZ_4_Thymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
