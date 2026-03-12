package ru.goncharov.Task_1;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.util.ArithmeticUtils;

/**
 * В рамках выполнения задачи необходимо:
 * Создать свой Java Maven проект;
 * Добавьте зависимость commons-math3 (предназначена для решения математических задач) и изучить интерфейс библиотеки.
 * Воспользоваться пакетом org.apache.commons.math3.stat и классом DescriptiveStatistics.
 * Создать коллекцию из числовых элементов.
 * С помощью объекта DescriptiveStatistics вычислить минимальное и максимальное значение, сумму и среднее арифметическое.
 * Воспользоваться пакетом org.apache.commons.math3.util. С помощью класса ArithmeticUtils найти :
 * факториал числа N.
 * Наименьшее общее частное двух чисел
 * Наибольший общий делитель двух чисел
 * Проверить что число N это степень двойки
 */
public class Main {
    static void main() {
        double [] array = {1,2,3,4,5,6,7,8,9,10};
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(array);
        System.out.println(descriptiveStatistics.getMin());
        System.out.println(descriptiveStatistics.getMax());
        System.out.println(descriptiveStatistics.getMean());
        System.out.println(descriptiveStatistics.getSum());

        System.out.println(ArithmeticUtils.factorial(5));
        System.out.println(ArithmeticUtils.gcd(10,30));
        System.out.println(ArithmeticUtils.lcm(15,25));
        System.out.println(ArithmeticUtils.isPowerOfTwo(16));


    }
}
