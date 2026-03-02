package Sem_4_Collections.Task_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {
    static void main() {
        List<String> names = new ArrayList<>(Arrays.asList("Иван", "Сергей", "Александр", "Ирина", "Светлана", "Иван", "Светлана"));
        Set<String> namesSet = Programm.convertListToSet(names);
        //System.out.println(namesSet);
        String minSetElement = Programm.minLengthName(namesSet);
        System.out.println(minSetElement);
        String maxSetElement = Programm.maxLengthName(namesSet);
        //System.out.println(maxSetElement);

        Set<String> newSetNames = Programm.filterNamesWithoutA(namesSet);
        System.out.println(newSetNames);

    }
}
