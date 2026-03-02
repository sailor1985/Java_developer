package Sem_4_Collections.Task_3;

import java.util.*;

/*
Создайте телефонный справочник с помощью Map - телефон это ключ, а имя значение
Найдите человека с самым маленьким номером
Найдите номер телефона человека, чье имя самое большое в алфавитном порядке
 */
public class Programm {

    static void main() {
        Map<String, String> phonebook = new HashMap<>();
        phonebook.put("89851233958", "Иван");
        phonebook.put("89169780414", "Сергей");
        phonebook.put("89871472589", "Александр");
        phonebook.put("89853692547", "Петр");
            System.out.println(findMinPhonenumber(phonebook));
        System.out.println(maxNumber(phonebook));
    }

    public static String findMinPhonenumber(Map<String, String> phonebook) {
        if (phonebook.isEmpty()) return null;

        // Находим минимальный ключ прямо из keySet
        String minKey = phonebook.keySet().stream()
                .min(Comparator.naturalOrder())
                .orElse(null);

        // Просто возвращаем значение по этому ключу. Цикл не нужен!
        return phonebook.get(minKey);
    }
    //Найдите номер телефона человека, чье имя самое большое в алфавитном порядке
    public static String maxNumber (Map<String, String> phonebook) {
        if (phonebook.isEmpty()) return null;

        return phonebook.entrySet().stream().
                max(Map.Entry.comparingByValue(Comparator.naturalOrder())).map(Map.Entry::getKey).orElse(null);
    }
}
