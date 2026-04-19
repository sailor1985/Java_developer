package DZ_6_DesignAPIForServerApp;

import DZ_6_DesignAPIForServerApp.model.Note;
import DZ_6_DesignAPIForServerApp.model.Tag;
import DZ_6_DesignAPIForServerApp.model.User;
import DZ_6_DesignAPIForServerApp.repository.NotesRepository;
import DZ_6_DesignAPIForServerApp.repository.TagRepository;
import DZ_6_DesignAPIForServerApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final UserRepository userRepository;
    private final NotesRepository notesRepository;
    private final TagRepository tagRepository;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional // Обеспечивает сохранение связей в промежуточной таблице
    public void initData() {
        // Проверяем, пуста ли база по пользователям (главный триггер)
        if (userRepository.count() > 0) {
            return;
        }

        // 1. Создаем и сохраняем пользователей
        User admin = userRepository.save(new User("Admin_Ivan", 30));
        User dev = userRepository.save(new User("Dev_Petr", 25));
        User tester = userRepository.save(new User("Tester_Anna", 22));

        // 2. Создаем и сохраняем теги (привязываем их к созданным пользователям через userId)
        Tag urgent = tagRepository.save(new Tag("Urgent", "#FF0000", "Срочно к выполнению", admin.getId()));
        Tag java = tagRepository.save(new Tag("Java", "#00FF00", "Связано с кодом Java", dev.getId()));
        Tag bug = tagRepository.save(new Tag("Bug", "#FFA500", "Отчет об ошибке", tester.getId()));

        // 3. Создаем заметки

        // Заметка 1: Принадлежит админу, теги: Urgent и Java
        Note note1 = new Note("Запуск релиза", "Проверить готовность продакшена", admin.getId());
        note1.getTags().add(urgent);
        note1.getTags().add(java);

        // Заметка 2: Принадлежит разработчику, тег: Java
        Note note2 = new Note("Изучение Spring 4", "Разобраться с новыми фичами Spring", dev.getId());
        note2.getTags().add(java);

        // Заметка 3: Принадлежит тестеру, теги: Bug и Urgent
        Note note3 = new Note("Ошибка авторизации", "Не работает вход через мобильное приложение", tester.getId());
        note3.getTags().add(bug);
        note3.getTags().add(urgent);

        // 4. Сохраняем заметки (связи в NOTE_TAGS запишутся автоматически)
        notesRepository.saveAll(List.of(note1, note2, note3));

        System.out.println(">>> Данные успешно инициализированы:");
        System.out.println(">>> Создано пользователей: 3");
        System.out.println(">>> Создано тегов: 3");
        System.out.println(">>> Создано заметок со связями: 3");
    }
}