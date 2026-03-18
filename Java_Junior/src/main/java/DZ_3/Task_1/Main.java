package DZ_3.Task_1;

import java.io.*;

public class Main {
    static void main() throws IOException, ClassNotFoundException {
        Person person = new Person("Владислав", 30);
        String personFile = "src/main/resources/person.bin";

        serialObj(person, personFile); //Сериализуем Person

        Person outPerson = (Person) deSerialObj(personFile); //Десериализуем из файла
        System.out.println(outPerson);
    }
    // Метод для сериализации объекта в файл
    public static void serialObj(Object o, String file) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(o);
        }
        System.out.println("Объект " + o.getClass().getSimpleName() + " сериализован");
    }

    // Метод для десериализации объекта из файла
    public static Object deSerialObj(String file) throws IOException, ClassNotFoundException {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return objectInputStream.readObject();
        }
    }


}
