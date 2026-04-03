package Sem_3_SpringFarServerApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import Sem_3_SpringFarServerApp.model.Issue;
import Sem_3_SpringFarServerApp.model.Reader;
import Sem_3_SpringFarServerApp.repository.IssueRepository;
import Sem_3_SpringFarServerApp.repository.ReaderRepository;

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
