package Sem_5.Task_2;

import java.io.*;

public class FileExchange {
    static void main() throws IOException {
        System.out.println(makeString("src/main/resources/test_2.txt"));
        writeFile("src/main/resources/test_2.txt", 'a');
    }

    public static String makeString (String path) throws IOException {
        try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream(path))) {
            return new String(stream.readAllBytes());
        }
    }

    public static void writeFile (String path, char exchangeChar) throws IOException {
        String string = makeString(path);
        String result = string.replaceAll(String.valueOf(exchangeChar), " ");

        try (FileWriter writer = new FileWriter(path)) {
            writer.write(result);
        }
    }
}