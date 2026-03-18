package DZ_2;

import java.lang.reflect.Method;

public class Programm {
    static void main() throws ClassNotFoundException {
        Class<?> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();
        System.out.println("Список методов класса String (всего: " + methods.length + "):");

        for (int i = 0; i < methods.length; i++) {
            System.out.print(methods[i].getName());
            if (i < methods.length - 1) { // Если это не последний элемент, выводим запятую
                System.out.print(", ");
            }
            if ((i + 1) % 15 == 0) {// Если вывели 15 методов (индекс + 1 делится на 15), переходим на новую строку
                System.out.println();
            }
        }
        System.out.println();
    }
}
