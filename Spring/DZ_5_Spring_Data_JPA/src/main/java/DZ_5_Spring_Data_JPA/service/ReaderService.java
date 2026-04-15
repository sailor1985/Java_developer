package DZ_5_Spring_Data_JPA.service;


import DZ_5_Spring_Data_JPA.model.Issue;
import DZ_5_Spring_Data_JPA.model.Reader;
import DZ_5_Spring_Data_JPA.repository.IssueRepository;
import DZ_5_Spring_Data_JPA.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderService {
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;

    public List<Reader> getAll() {
        return readerRepository.findAll();
    }

    public Reader getById(long id) {
        return readerRepository.findById(id).orElse(null);
    }

    public Reader create(String name) {
        return readerRepository.save(new Reader(name));
    }

    public void delete(long id) {
        readerRepository.deleteById(id);
    }

    // Поиск всех выдач конкретного читателя
    public List<Issue> getIssuesByReader(long readerId) {
        return issueRepository.findByReaderId(readerId);
    }
}