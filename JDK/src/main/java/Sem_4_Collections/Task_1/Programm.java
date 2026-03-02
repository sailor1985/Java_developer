package Sem_4_Collections.Task_1;


import java.util.*;

/*
Создайте коллекцию мужских и женских имен с помощью интерфейса List
Отсортируйте коллекцию в алфавитном порядке
Отсортируйте коллекцию по количеству букв в слове
Разверните коллекцию
 */
public class Programm {

    public static void sortByAlphabet(List<String>list) {
        Collections.sort(list);
    }

    public static void sortByLength(List<String> list) {
        list.sort(Comparator.comparing(String::length));
    }
    public static void reversList(List<String> list) {
        Collections.reverse(list);
    }
}
