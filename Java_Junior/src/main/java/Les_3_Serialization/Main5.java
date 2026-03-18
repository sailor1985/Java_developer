package Les_3_Serialization;

import lombok.AllArgsConstructor;

import java.io.*;

public class Main5 {
    static void main() throws IOException, ClassNotFoundException {
        //MyFCs myFCs = new MyFCs("Ivanov", "Ivan", "Ivanovich");
        //serialObj(myFCs,"ser");

        MyFCs myFCs = (MyFCs) deSerialObj("ser");
        System.out.println(myFCs);
    }

    @AllArgsConstructor
    static class MyFCs implements Serializable {
        public String lName;
        public String fName;
        public String patronymic;

        @Override
        public String toString() {
            return String.format("%s %s.%s.",
                    fName,
                    lName.toUpperCase().charAt(0),
                    patronymic.toUpperCase().charAt(0));
        }
    }

    // Метод для записи объекта в файл
    public static void serialObj(Object o, String file) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(o);
        }
    }

    // Метод для чтения объекта из файла
    public static Object deSerialObj(String file) throws IOException, ClassNotFoundException {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return objectInputStream.readObject();
        }
    }
}
