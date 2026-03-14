package DZ_1;

import java.util.Arrays;
import java.util.List;

/*
Напишите программу, которая использует Stream API для обработки списка чисел.
Программа должна вывести на экран среднее значение всех четных чисел в списке.
 */
public class Main {
    static void main() {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(integerList.stream().filter(s->s%2==0).mapToInt(Integer::intValue).average().orElse(0.0));
    }
}
