package Sem_1_LambdasAndStreamAPI.Task_1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class Book {
    private final String title;
    private final String author;
    private final int year;
}
