package ru.goncharov.Task_3;

import java.io.IOException;
import java.io.InputStream;

public class ReadFile {
    static void main() throws IOException {
        System.out.println(new ReadFile().readFile());
    }

    public String readFile() throws IOException {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("test.txt")) {
            return new String(inputStream.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
