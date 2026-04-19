package DZ_6_DesignAPIForServerApp.service;

import DZ_6_DesignAPIForServerApp.dto.NoteDetailedDTO;
import DZ_6_DesignAPIForServerApp.dto.NoteListWrapper;
import DZ_6_DesignAPIForServerApp.dto.NoteSummaryDTO;
import DZ_6_DesignAPIForServerApp.dto.PagingResponse;
import DZ_6_DesignAPIForServerApp.model.Note;
import DZ_6_DesignAPIForServerApp.model.Tag;
import DZ_6_DesignAPIForServerApp.repository.NotesRepository;
import DZ_6_DesignAPIForServerApp.repository.TagRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotesService {

    private final NotesRepository notesRepository;
    private final TagRepository tagRepository;

    // Создать заметку
    public Note createNote(Note note) {
        return notesRepository.save(note);
    }

    // Прочитать заметку по ID
    public Note findNoteById(Long id) {
        return notesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Заметка с ID " + id + " не найдена"));
    }

    // Обновление заметки
    @Transactional
    public Note updateNote(Long noteId, String newTitle, String newContent) {
        Note note = findNoteById(noteId);
        note.setTitle(newTitle);
        note.setContent(newContent);
        return notesRepository.save(note);
    }

    // Удаление заметки
    public void deleteNote(Long noteId) {
        if (!notesRepository.existsById(noteId)) {
            throw new EntityNotFoundException("Не удалось удалить: заметка не найдена");
        }
        notesRepository.deleteById(noteId);
    }

    // Загрузить все заметки (без пагинации)
    public List<Note> getAllNotes() {
        return notesRepository.findAll();
    }

    // Привязать тэг к заметке
    @Transactional
    public void assignTagToNote(Long noteId, Long tagId) {
        Note note = notesRepository.findById(noteId)
                .orElseThrow(() -> new EntityNotFoundException("Заметка не найдена"));
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(() -> new EntityNotFoundException("Тег не найден"));

        if (!note.getTags().contains(tag)) {
            note.getTags().add(tag);
            // При @Transactional save вызывать не обязательно, но можно для наглядности
            notesRepository.save(note);
        }
    }

    // Получить список заметок с пагинацией и фильтром по тегу
    public NoteListWrapper getAllNotesPaginated(Pageable pageable, Long tagId) {
        Page<Note> notePage;

        // Фильтруем по тегу, если он передан, иначе берем все
        if (tagId != null) {
            notePage = notesRepository.findAllByTags_Id(tagId, pageable);
        } else {
            notePage = notesRepository.findAll(pageable);
        }

        // Превращаем Entity в DTO для короткого списка (как в вашем ТЗ)
        List<NoteSummaryDTO> dtos = notePage.getContent().stream().map(note -> {
            NoteSummaryDTO dto = new NoteSummaryDTO();
            dto.setId(note.getId());
            dto.setTitle(note.getTitle());
            dto.setCreatedAt(note.getCreatedAt());
            // Мапим список объектов Tag в список их ID
            dto.setTags(note.getTags().stream().map(Tag::getId).toList());
            return dto;
        }).toList();

        // Формируем объект пагинации
        PagingResponse paging = new PagingResponse(
                notePage.getNumber(),
                notePage.getSize(),
                notePage.getTotalElements(),
                notePage.getTotalPages()
        );

        return new NoteListWrapper(dtos, paging);
    }

    @Transactional(readOnly = true)
    public NoteDetailedDTO getNoteDetailed(Long id) {
        Note note = notesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Заметка с ID " + id + " не найдена"));

        NoteDetailedDTO dto = new NoteDetailedDTO();
        dto.setId(note.getId());
        dto.setTitle(note.getTitle());
        dto.setContent(note.getContent());
        dto.setCreatedAt(note.getCreatedAt());
        dto.setDeletedAt(note.getDeletedAt());
        dto.setUserId(note.getUserId());

        // Превращаем список объектов Tag в список строк (их названий)
        dto.setTags(note.getTags().stream()
                .map(Tag::getTitle)
                .toList());

        return dto;
    }
}