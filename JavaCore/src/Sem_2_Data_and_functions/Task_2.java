package Sem_2_Data_and_functions;

import java.util.Arrays;
import java.util.TreeMap;

public class Task_2 {
    static void main() {
        int[] arr = { 1, 3, 2, 6, 9, 10, 1, 2, 5, 4, 9, 6, 20 };
        System.out.println(Arrays.toString(countSort(arr)));
    }
    public static int[] countSort(int[] arr) {

        // Временный массив для результата
        int[] tmpArr = new int[arr.length];

        // Карта: число -> сколько раз оно встретилось
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // 1. Подсчёт количества вхождений каждого числа
        for (int value : arr) {
            int count = map.getOrDefault(value, 0);
            map.put(value, count + 1);
        }

        // 2. Формирование отсортированного массива
        int i = 0;
        for (Integer key : map.keySet()) {
            for (int j = 0; j < map.get(key); j++) {
                tmpArr[i++] = key;
            }
        }

        return tmpArr;
    }
}
