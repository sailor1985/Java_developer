package DZ_4.Task_2;

import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EasyDownloader {
    static void main() {
        String[] urls = {
                "https://raw.githubusercontent.com/git/git/master/README.md",
                "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png",
                "https://example.com"
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Сколько потоков одновременно использовать? ");
        int threadCount = scanner.nextInt();

        // СОЗДАЕМ ПУЛ ПОТОКОВ.
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        System.out.println("Загрузка началась...");

        // Используем .length для массива
        for (int i = 0; i < urls.length; i++) {
            String url = urls[i];
            String fileName = "file_" + i + ".dat";

            // Отдаем задачу исполнителю (executor)
            executor.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " качает: " + url);

                    // Способ создания URL
                    InputStream in = URI.create(url).toURL().openStream();

                    // Копируем данные в файл
                    Files.copy(in, Paths.get(fileName), StandardCopyOption.REPLACE_EXISTING);

                    System.out.println("Готово: " + fileName);
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            });
        }

        // Обязательно закрываем пул, когда все задачи розданы
        executor.shutdown();
    }
}
