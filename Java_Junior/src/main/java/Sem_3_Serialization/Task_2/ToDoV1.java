package Sem_3_Serialization.Task_2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ToDoV1 implements Serializable {
    private String title;
    private boolean isDone;

    public ToDoV1() {
    }
}
