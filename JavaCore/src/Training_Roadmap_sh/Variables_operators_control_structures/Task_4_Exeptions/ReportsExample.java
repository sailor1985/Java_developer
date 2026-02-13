package Training_Roadmap_sh.Variables_operators_control_structures.Task_4_Exeptions;

/**
 * Работа с несколькими файлами и директориями: Напишите программу, которая:
 * Создает директорию с именем "reports".
 * Внутри "reports" создает два файла: "report1.txt" и "report2.txt".
 * Записывает в "report1.txt" несколько строк текста.
 * Копирует содержимое "report1.txt" в "report2.txt".
 * Считывает и выводит на консоль содержимое "report2.txt".
 * Удаляет оба файла и директорию "reports".
 * Используйте классы из пакета java.nio.file.
 */
import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class ReportsExample {
    static void main() {
        Path reportsDir = Paths.get("reports");
        Path report1 = reportsDir.resolve("report1.txt");
        Path report2 = reportsDir.resolve("report2.txt");

        try {
            // 1. Создать директорию "reports"
            Files.createDirectories(reportsDir);

            // 2. Создать два файла
            Files.createFile(report1);
            Files.createFile(report2);

            // 3. Записать несколько строк в report1.txt
            List<String> lines = List.of(
                    "Первая строка отчёта",
                    "Вторая строка отчёта",
                    "Третья строка отчёта"
            );
            Files.write(report1, lines);

            // 4. Скопировать содержимое report1.txt → report2.txt
            Files.copy(report1, report2, StandardCopyOption.REPLACE_EXISTING);

            // 5. Считать и вывести содержимое report2.txt
            List<String> readLines = Files.readAllLines(report2);
            for (String line : readLines) {
                System.out.println(line);
            }

            // 6. Удалить файлы и директорию
            Files.delete(report1);
            Files.delete(report2);
            Files.delete(reportsDir);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}