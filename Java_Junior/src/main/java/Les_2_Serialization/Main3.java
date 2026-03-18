package Les_2_Serialization;

import java.io.*;
import java.util.ArrayList;

public class Main3 {
    static void main() throws IOException {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(Character.getName(i));
        }
        serialObj(list,"ser");


    }

    // Метод для записи объекта в файл
    public static void serialObj(Object o, String file) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(o);
        }
    }
}
