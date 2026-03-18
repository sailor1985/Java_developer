package Les_3_Serialization;

import java.io.*;

public class Main2 {
    static void main() throws Exception {
        try (FileInputStream fileInputStream = new FileInputStream("ser");) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            String s = (String) objectInputStream.readObject();
            System.out.println("Прочитано из файла: " + s);
        }
    }
}
