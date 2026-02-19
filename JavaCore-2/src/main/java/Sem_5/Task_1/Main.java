package Sem_5.Task_1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static void main() throws IOException {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        String path = "src/main/resources/text.txt";
        String array = Arrays.toString(arr);
        //writeToFile(array);
        writeToFile(writeZero(arr));

        int[] content = readFromFile("src/main/resources/text.txt");
        if (content != null) {
            System.out.printf("Содержимое файла: " + path + " " + Arrays.toString(content));;
        }


    }

    public static void writeToFile(String arr) {
        try (FileWriter fileWriter = new FileWriter("src/main/resources/text.txt")) {
            fileWriter.write(arr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int[] readFromFile(String path) {
        ArrayList <Integer> arrayList = new ArrayList<>();
        try (FileReader fileReader = new FileReader(path)) {
            int character;
            boolean mark =true;
            // Читаем по одному символу, пока не получим -1
            while ((character = fileReader.read()) != -1) {
                char temp = (char) character;
                // Преобразуем число в символ и выводим
                if ((character != ('0'))) {
                    try {
                        arrayList.add(Integer.parseInt(String.valueOf(temp)));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
            int [] result = new int[arrayList.size()];
            int index = 0;
            for (Integer integer : arrayList) {
                result[index++] = integer;
            }
            return  result;

        } catch (IOException e) {
            // Обработка случая, если файл не найден или поврежден
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            return null;
        }
    }

    //Добавление "0", как разделителя в числа массива
    public static String writeZero(int[] arr) {
        StringBuilder sb = new StringBuilder();

        if (arr == null || arr.length == 0) return "[]";

        for (int i = 0; i <= arr.length - 1; i++) {
            sb.append(arr[i]).append("0");
        }
        return sb.toString();
    }
}