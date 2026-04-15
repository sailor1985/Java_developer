package DZ_5_Spring_Data_JPA.api;

import lombok.Data;

@Data
public class IssueRequest {
    private Long readerId;
    private Long bookId;
}