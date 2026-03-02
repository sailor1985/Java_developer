package DZ_3.Task_1;

public class Main {
    static void main() {
        System.out.println("Сумма: " + Calculator.sum(10, 5.5f));          // Integer и Float
        System.out.println("Умножение: " + Calculator.multiply(2L, 3.14)); // Long и Double
        System.out.println("Деление: " + Calculator.divide(10, 3));        // Integer и Integer
        System.out.println("Вычитание: " + Calculator.subtract(5.5, 2));
    }
}
