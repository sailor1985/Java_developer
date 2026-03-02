package Sem_4_Collections.Task_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static void main() {
        List<String> names = new ArrayList<>(Arrays.asList("Иван", "Сергей", "Александр", "Ирина", "Светлана"));
        Programm.sortByAlphabet(names);
        System.out.println(names);
        Programm.sortByLength(names);
        System.out.println(names);
        Programm.reversList(names);
        System.out.println(names);

    }
}

