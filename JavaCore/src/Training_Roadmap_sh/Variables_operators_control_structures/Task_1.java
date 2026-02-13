package Training_Roadmap_sh.Variables_operators_control_structures;

import java.util.Arrays;

public class Task_1 {
    /**
     * Сумма Четных Чисел:
     * Используя цикл for, найдите сумму всех четных чисел от 1 до 100 включительно.
     * Используйте оператор continue, чтобы пропустить нечетные числа, если вы перебираете все числа.
     * Выведите итоговую сумму.
     */

     static void main() {
        int[] arr = CreateArray();
        System.out.println("Создан массив: " + Arrays.toString(CreateArray()));
        System.out.println("Сумма всех четных чисел в нем: " + Sum(arr));
    }

    public static int [] CreateArray () {
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        return numbers;
    }

    public static int Sum (int[] arr) {
        int sum = 0;
        for (int j : arr) {
            if (j % 2 == 0) {
                sum += j;
            }
        }
        return sum;
    }
}
