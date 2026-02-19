package DZ_5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class Task_1_BackupSystem {
    static void main() throws IOException {
        String sourcePath = "src/main/java/Sem_5";
        String backupPath = "src/main/resources/backup";
        createBackup(sourcePath, backupPath);
    }

    public static void createBackup(String sourcePath, String backupPath) throws IOException {

            Path sourceDir = Path.of(sourcePath);
            Path backupDir = Path.of(backupPath);

            //Создаем целевую папку, если её нет
            Files.createDirectories(backupDir);

            // Открываем поток для чтения списка файлов. Files.list() возвращает поток (Stream) путей.
            try (Stream<Path> files = Files.list(sourceDir)) {
                // Перебираем каждый найденный элемент
                files.forEach(file -> {
                    // Проверяем, что это обычный файл, а не папка или ссылка
                    if (Files.isRegularFile(file)) {
                        // Формируем полный путь для копии: папка бэкапа + имя оригинального файла
                        Path targetFile = backupDir.resolve(file.getFileName());
                        try {
                            // Копируем файл, разрешая перезапись, если такая копия уже есть
                            Files.copy(file, targetFile, StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e) {
                            System.out.println("Проблема с копированием файлов " + file.getFileName() + ": " + e.getMessage());
                        }
                    }
                });
            } catch (IOException e) {
                System.out.println("Проблема при чтении исходного каталога: " + e.getMessage());
            }
        }
    }