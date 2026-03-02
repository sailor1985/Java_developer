package Sem_4_Collections.Task_2;

import java.util.*;
import java.util.function.Consumer;

/*
Создайте коллекцию мужских и женских имен с помощью интерфейса List - добавьте повторяющиеся значения
Получите уникальный список Set на основании List
Определите наименьший элемент (алфавитный порядок)
Определите наибольший элемент (по количеству букв в слове, но в обратном порядке)
Удалите все элементы, содержащие букву А
 */
public class Programm {

    public static Set<String> convertListToSet (List<String> list) {
        return new HashSet<>(list);
    }

    public static String minLengthName(Set<String> names) {
        return names.stream().min(Comparator.naturalOrder()).orElse(null);
    }

    public static String maxLengthName (Set<String> names) {
        return names.stream().max(Comparator.comparing(String::length)).orElse(null);
    }

    public static Set<String> filterNamesWithoutA(Set<String> names) {
        Set<String> result = new LinkedHashSet<>();
        for (String name : names) {
            if (!name.toLowerCase().contains("а")) {
                result.add(name);
            }
            //Эта строчка, если нужно было бы удалить букву А
            //result.add(name.replaceAll("[Аа]", ""));
        }

        //return names.removeIf(name-> names.contains("а")); второй вариант
        return result;
    }
}