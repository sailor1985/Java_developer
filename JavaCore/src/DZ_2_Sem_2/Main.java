package DZ_2_Sem_2;

import java.util.Arrays;
import java.util.Random;

public class Main {
    static void main(String[] args) {
        /**
         * 1. Написать метод, возвращающий количество чётных элементов массива.
         *      countEvens([2, 1, 2, 3, 4]) → 3
         *      countEvens([2, 2, 0]) → 3
         *      countEvens([1, 3, 5]) → 0
         * 2. Написать функцию, возвращающую разницу между самым большим и самым маленьким элементами
         *    переданного не пустого массива.
         * 3. Написать функцию, возвращающую истину, если в переданном массиве есть два соседних элемента,
         * с нулевым значением.
         */
        int[] countEvens1 = {2, 1, 2, 3, 4};
        int[] countEvens2 = {2, 2, 0};
        int[] countEvens3 = {1, 3, 5};
        System.out.println("Количество четных элементов в массиве " + Arrays.toString(countEvens1) + " = " + sum(countEvens1));
        System.out.println("Количество четных элементов в массиве " + Arrays.toString(countEvens2) + " = " + sum(countEvens2));
        System.out.println("Количество четных элементов в массиве " + Arrays.toString(countEvens3) + " = " + sum(countEvens3) + "\n");

        int[] randomArr = randomArray();
        System.out.println("Разница между максимальным и минимальным элементами массива: " + Arrays.toString(randomArr) + " равна " + result(randomArr) + "\n");

        int [] boolArray = {2,5,6,9,0,0,3,2,5,6};
        System.out.println("Массив " + Arrays.toString(boolArray) +  "\n" + checkTwoZeroes(boolArray));
    }

    public static int sum(int[] arr) {
        int count = 0;
        for (int chet : arr) {
            if (chet % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int[] randomArray() {
        int[] array = new int[5];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static int result(int[] arr) {
        if (arr == null || arr.length == 0) return 0; // Проверка на пустой массив

        int minValue = arr[0];
        int maxValue = arr[0];

        for (int j : arr) {
            if (j > maxValue) maxValue = j;
            if (j < minValue) minValue = j;
        }

        System.out.println("Максимальный элемент: " + maxValue);
        System.out.println("Минимальный элемент: " + minValue);
        return maxValue - minValue;
    }

    public static boolean checkTwoZeroes(int[] arr) {
           for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == 0 & arr[i+1] ==0) {
               return true;
            }
        }
        return false;
    }
    }
