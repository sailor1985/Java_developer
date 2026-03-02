package DZ_3.Task_2;

/*
Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true,
если они одинаковые, и false в противном случае.
Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.
*/
public class Main {
    static void main() {
        Cat cat_1 = new Cat("Барсик", 11, "серо-буро-голубой");
        Cat cat_2 = new Cat("Леопольд", 17, "сиреневый");
        Cat cat_3 = new Cat("Пушинка", 8, "белый");
        Cat cat_4 = new Cat("Клеопатра", 2, "черный");

        Animal [] animals  = {cat_1, cat_2, cat_3};
        Cat [] cats_3 = {cat_1, cat_2, cat_3};
        Cat [] cats_4 = {cat_1, cat_2, cat_3, cat_4};

        System.out.println(compareArrays(animals, cats_3));
        System.out.println(compareArrays(animals, cats_4));
    }
    public static <T> boolean compareArrays(T[] array1, T[] array2) {
        // Проверяем длину
        if (array1.length != array2.length) {
            return false;
        }
        // Сравниваем элементы (по условию задания они одного типа)
        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].getClass().equals(array2[i].getClass())) {
                return false; // Если типы элементов внутри массивов вдруг разные
            }
        }
        return true;
    }
}