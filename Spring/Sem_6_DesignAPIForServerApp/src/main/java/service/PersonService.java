package Sem_5.DesignAPIForServerApp.service;

import Sem_5.DesignAPIForServerApp.model.Person;
import Sem_5.DesignAPIForServerApp.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    @Transactional
    public void updatePerson(Long id, String newName, Integer newAge) {
        Person person = repository.findById(id).
                orElseThrow();
        person.setName(newName);
        repository.save(person);

        //fail();

        person.setAge(newAge);
        repository.save(person);
    }

    public void fail(){
        throw   new RuntimeException("fail");
    }



}
