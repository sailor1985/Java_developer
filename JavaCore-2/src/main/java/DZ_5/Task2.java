package DZ_5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task2 {
    static void main(String[] args) {
        // Исходное поле 3х3 (значения 0-3)
        int[][] gameField = {
                {1, 0, 2},
                {3, 1, 0},
                {2, 3, 1}
        };

        String fileName = "src/main/resources/gamefield.bin";

        System.out.println("Исходное поле:");
        printGameField(gameField);

        // Записываем 3 байта в файл
        writeGameFieldToThreeBytes(gameField, fileName);

        // Считываем и восстанавливаем
        int[][] importedField = readGameFieldFromThreeBytes(fileName);

        System.out.println("\nПоле, считанное из 3-х байтового файла:");
        printGameField(importedField);
    }

    /**
     * Записывает поле 3х3 в файл объемом ровно 3 байта.
     * Каждый байт хранит одну строку (3 ячейки по 2 бита каждая).
     */
    public static void writeGameFieldToThreeBytes(int[][] field, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            for (int i = 0; i < 3; i++) {
                // Пакуем 3 числа в один байт:
                // Первое число сдвигаем на 4 бита, второе на 2, третье оставляем как есть
                int packedByte = (field[i][0] << 4) | (field[i][1] << 2) | field[i][2];
                fos.write(packedByte);
            }
            System.out.println("\nФайл успешно записан. Размер файла: " + Files.size(Path.of(fileName)) + " байт(а).");
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }
    }

    /**
     * Читает 3 байта из файла и восстанавливает массив 3х3.
     */
    public static int[][] readGameFieldFromThreeBytes(String fileName) {
        int[][] field = new int[3][3];
        try (FileInputStream fis = new FileInputStream(fileName)) {
            for (int i = 0; i < 3; i++) {
                int b = fis.read();
                // Распаковываем байт обратно в 3 числа, используя маску 0x03 (00000011 в двоичной)
                field[i][0] = (b >> 4) & 0x03;
                field[i][1] = (b >> 2) & 0x03;
                field[i][2] = b & 0x03;
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
        return field;
    }

    public static void printGameField(int[][] gameField) {
        for (int[] row : gameField) {
            for (int cell : row) {
                String symbol = switch (cell) {
                    case 0 -> "•"; // Пусто
                    case 1 -> "X"; // Крестик
                    case 2 -> "O"; // Нолик
                    case 3 -> "?"; // Резерв
                    default -> "!";
                };
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }
}