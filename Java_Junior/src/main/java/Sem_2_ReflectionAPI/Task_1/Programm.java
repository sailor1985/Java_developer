package Sem_2_ReflectionAPI.Task_1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/*
Получите информацию о классе Person c использованием Reflection API
Выведите на экран все поля и методы класса
Создайте экземпляр класс Person c использованием Reflection API
Установите значения полей и вызовете методы
Реализуйте обработку исключений для обеспечения корректного взаимодействия с Reflection API
 */
public class Programm {

    static void main() throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        Class<?> personalClass = Class.forName("Sem_2_ReflectionAPI.Task_1.Person");

        //Получить список всех полей
        Field[] fields = personalClass.getDeclaredFields();

        for (Field field : fields) {
            System.out.printf("Поле " + field.getName() +"\n");
        }

        //Получить список всех конструкторов
        Constructor[] constructors = personalClass.getConstructors();

        //Создадим экземпляр класса
        Object personalInstance = constructors[0].newInstance(null);

        Field nameField = personalClass.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(personalInstance, "Alice");

        Method displayInfo =  personalClass.getDeclaredMethod("displayInfo");
        displayInfo.invoke(personalInstance);

    }

}
