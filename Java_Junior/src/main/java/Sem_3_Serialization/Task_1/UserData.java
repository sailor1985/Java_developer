package Sem_3_Serialization.Task_1;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;


@Getter
@AllArgsConstructor
public class UserData implements Serializable {
    private String name;
    private int age;
    private transient String password;
}
