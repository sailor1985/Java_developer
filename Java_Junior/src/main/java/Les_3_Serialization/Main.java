package Les_3_Serialization;

import java.io.*;

public class Main {
    static void main() throws IOException {
        String str = "Всем привет";
        try (FileOutputStream fileOutputStream = new FileOutputStream("ser")) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(str);
            objectOutputStream.flush();
        }
        System.out.println("Файл успешно перезаписан в бинарном формате!");
    }
}
