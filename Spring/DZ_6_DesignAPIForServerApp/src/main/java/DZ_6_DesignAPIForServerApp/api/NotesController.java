package DZ_6_DesignAPIForServerApp.api;

import DZ_6_DesignAPIForServerApp.dto.NoteDetailedDTO;
import DZ_6_DesignAPIForServerApp.dto.NoteListWrapper;
import DZ_6_DesignAPIForServerApp.service.NotesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
@Tag(name = "Заметки", description = "Управление заметками и их тегами")
public class NotesController {
    private final NotesService notesService;

    /**
     * GET /notes/{id} - получить описание заметки
     */
    @GetMapping("/{id}")
    public ResponseEntity<NoteDetailedDTO> getNoteById(@PathVariable Long id) {
        return ResponseEntity.ok(notesService.getNoteDetailed(id));
    }

    /**
     * GET /notes?page=0&size=5 - получить список всех заметок
     * GET /notes?tag={tagId} - получить список заметок по тэгу
     */
    @GetMapping
    public ResponseEntity<NoteListWrapper> getNotes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) Long tag) {

        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(notesService.getAllNotesPaginated(pageable, tag));
    }

    /**
     * PUT /notes/{noteId}/tag/{tagId} - Привязать тэг к заметке
     */
    @PutMapping("/{noteId}/tag/{tagId}")
    public ResponseEntity<Void> addTagToNote(
            @PathVariable Long noteId,
            @PathVariable Long tagId) {

        notesService.assignTagToNote(noteId, tagId);
        return ResponseEntity.noContent().build();
    }
}
