package Les_3_Serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Main4 {
    static void main() throws IOException, ClassNotFoundException {
        ArrayList<String> list = null;
        list = (ArrayList<String>) deSerialObj("ser");
        System.out.println(list);

    }

    // Метод для чтения объекта из файла
    public static Object deSerialObj(String file) throws IOException, ClassNotFoundException {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return objectInputStream.readObject();
        }
    }
}
