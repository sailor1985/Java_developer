package Training_Roadmap_sh.Variables_operators_control_structures;

import java.util.Scanner;

public class Task_2 {
    /**
     * Калькулятор Операций:
     * Объявите две переменные num1 и num2 типа double и одну переменную operator типа char
     * (например, +, -, *, /).
     * Используя конструкцию switch, выполните соответствующую арифметическую операцию над num1 и num2
     * в зависимости от значения operator.
     * Выведите результат.
     * Добавьте default блок для обработки неизвестных операторов.
     * Дополнительно: Реализуйте этот калькулятор в цикле while, который будет работать до тех пор,
     * пока пользователь не введет специальный символ для выхода (например, 'q').
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число: ");
        double first = scanner.nextDouble();

        System.out.println("Введите второе число: ");
        double second = scanner.nextDouble();

        System.out.println("Введите операцию (+, -, *, /): ");
        char op = scanner.next().charAt(0);

        System.out.println("Результат: " + Result(first, second, op));
    }

    public static double Result(double a, double b, char op) {
        double result = 0.0;

        switch (op) {
            case '+':
                result = a + b;break;
            case '-':
                result = a - b;break;
            case '*':
                result = a * b;break;
            case '/':
                result = a / b;break;
            default:
                System.out.println("Неизвестная операция");
        }
        return result;
    }
}