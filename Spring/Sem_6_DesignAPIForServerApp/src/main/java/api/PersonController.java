package Sem_5.DesignAPIForServerApp.api;

import Sem_5.DesignAPIForServerApp.model.Person;
import Sem_5.DesignAPIForServerApp.repository.PersonRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping
    @Operation(summary = "get all persons", description = "загружает всех пользователей, которые есть в системе")
    //@ApiResponses(
            //@ApiResponse(responseCode = "200", content = {})
    //)
    public ResponseEntity<List<Person>> getAll(){
        return ResponseEntity.ok(personRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getAll(@PathVariable Long id){
        return ResponseEntity.ok(personRepository.findById(id).orElseThrow());
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH})
    public ResponseEntity<Person> save(@RequestBody Person person){
        return ResponseEntity.ok(personRepository.save(person));
    }
}
