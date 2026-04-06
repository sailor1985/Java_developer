package DZ_4_Thymeleaf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import DZ_4_Thymeleaf.model.Issue;
import DZ_4_Thymeleaf.model.Reader;
import DZ_4_Thymeleaf.repository.IssueRepository;
import DZ_4_Thymeleaf.repository.ReaderRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ReaderService {
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;

    public List<Reader> getAllReaders() {
        return readerRepository.getAllReaders();
    }

    public Reader getReaderById(long id) {
        return readerRepository.getReaderById(id);
    }

    public boolean deleteReaderById(long id) {
        return readerRepository.deleteReaderById(id);
    }

    public Reader addReader(String name) {
        return readerRepository.addReader(name);
    }

    public List<Issue> getIssuesByReaderId(long id) {
        // Проверяем, существует ли вообще такой читатель
        if (readerRepository.getReaderById(id) == null) {
            throw new NoSuchElementException("Читатель не найден");
        }
        return issueRepository.findAllByReaderId(id);
    }


}
