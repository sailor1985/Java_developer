package DZ_3.Task_1;

/*
1. Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
sum(), multiply(), divide(), subtract(). Параметры этих методов — два числа разного типа,
над которыми должна быть произведена операция.
*/
public class Calculator {

    public static <T extends Number, V extends Number> double sum(T t, V v) {
        return t.doubleValue() + v.doubleValue();
    }

    public static <T extends Number, V extends Number> double multiply(T t, V v) {
        return t.doubleValue() * v.doubleValue();
    }

    public static <T extends Number, V extends Number> double divide(T t, V v) {
        if (v.doubleValue() == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return t.doubleValue() / v.doubleValue();
    }

    public static <T extends Number, V extends Number> double subtract(T t, V v) {
        return t.doubleValue() - v.doubleValue();
    }
}
