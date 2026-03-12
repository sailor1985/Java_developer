package ru.goncharov.Task_2;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Добавить зависимость Guava (популярная библиотека от Google, содержащая набор утилитарных механизмов).
 * Воспользоваться утилитарным классом Lists:
 * Развернуть список элементов
 * Получить лист Character из строки
 * Разделить лист на группы по 2 элемента
 * Воспользоваться утилитарным классом Sets
 * Получить итоговый Set из двух коллекций
 * Получить итоговый Set из общих элементов двух коллекций
 * Получить итоговый Set из непересекающихся элементов двух коллекций
 */

public class Main {

        static void main() {
                List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
                System.out.println("Развернутый лист: " + Lists.reverse(list));
                System.out.println("Строка преобразованная в список: " + Lists.charactersOf("abcdef"));
                System.out.println("Лист разделенный на элементы: " + Lists.partition(list, 2));

                System.out.println("======================================");

                List<Integer> list2 = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8, 9));
                System.out.println("Объединение двух коллекций: " + Sets.union(Set.copyOf(list), Set.copyOf(list2)));
                System.out.println("Пересечение двух коллекций: " + Sets.intersection(Set.copyOf(list), Set.copyOf(list2)));
                System.out.println("Непересекающиеся элементы двух коллекций: " + Sets.symmetricDifference(Set.copyOf(list), Set.copyOf(list2)));
        }

}
