package DZ_4_Thymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reader {
    public static long sequence = 1L;
    private long id;
    private String name;

    public Reader(String name) {
        this(sequence++,name);
    }
}
