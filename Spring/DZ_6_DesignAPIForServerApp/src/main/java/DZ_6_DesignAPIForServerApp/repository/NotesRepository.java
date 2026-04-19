package DZ_6_DesignAPIForServerApp.repository;

import DZ_6_DesignAPIForServerApp.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Note, Long> {
    Page<Note> findAllByTags_Id(Long tagId, Pageable pageable);
}
