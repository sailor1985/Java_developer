package Sem_2_ReflectionAPI.Task_2;

import java.lang.reflect.Field;

/*
Применение Reflection API  в разаработке

Реализуйте обобщенный метод, который принимает объект и выводит в консоль значение всех его полей
Создайте класс Car с различными полями (модель, цвет, год выпуска)
Примените Reflection API для вывода значений полей созданного объекта класса Car
с использованием ранее созданного метода
 */
public class Programm {
    static void main() throws IllegalAccessException {
        Car car = new Car("Toyota", "Blue", 2022);
        task2(car);
    }
    private static <T> void task2 (T obj) throws IllegalAccessException {
        Class<?> objectClass = obj.getClass();
        Field[] fields = objectClass.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            System.out.printf("%s: %s\n", field.getName(), field.get(obj));

        }
    }
}
