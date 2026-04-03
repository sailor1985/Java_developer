package Sem_3_SpringFarServerApp.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import Sem_3_SpringFarServerApp.model.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ReaderRepository {
    private final List<Reader> readers;

    public ReaderRepository() {
        this.readers = new ArrayList<>();
    }

    @PostConstruct
    public void generateData() {
        readers.addAll(List.of(
                new Reader("Игорь"),
                new Reader("Ибрагим де Бальде"),
                new Reader("Лукич")
        ));
    }

    public List<Reader> getAllReaders() {
        return List.copyOf(readers); // возвращаем копию списка
    }

    public Reader getReaderById(long id) {
        return readers.stream().filter(it->Objects.equals(it.getId(),id)).
                findFirst().orElse(null);
    }

    public boolean deleteReaderById(long id) {
        return readers.removeIf(reader ->Objects.equals(reader.getId(),id));
    }

    public Reader addReader(String name) {
        Reader reader = new Reader(name);
        readers.add(reader);
        return reader;
    }
}
