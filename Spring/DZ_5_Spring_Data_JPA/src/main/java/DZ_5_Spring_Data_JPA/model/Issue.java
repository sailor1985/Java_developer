package DZ_5_Spring_Data_JPA.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "issues")
@Data
@NoArgsConstructor
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_id", nullable = false)
    private Long bookId;

    @Column(name = "reader_id", nullable = false)
    private Long readerId;

    @Column(name = "issued_at")
    private LocalDateTime issuedAt;

    @Column(name = "returned_at")
    private LocalDateTime returnedAt;

    public Issue(Long bookId, Long readerId) {
        this.bookId = bookId;
        this.readerId = readerId;
        this.issuedAt = LocalDateTime.now();
    }
}