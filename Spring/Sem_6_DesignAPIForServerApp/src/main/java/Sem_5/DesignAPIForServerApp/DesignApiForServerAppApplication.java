package Sem_5.DesignAPIForServerApp;

import Sem_5.DesignAPIForServerApp.model.Person;
import Sem_5.DesignAPIForServerApp.repository.PersonRepository;
import Sem_5.DesignAPIForServerApp.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
@EnableConfigurationProperties({ReaderProperties.class})
@Slf4j
public class DesignApiForServerAppApplication {

	private final PersonService service;
	private final PersonRepository repository;
	//private final ReaderProperties properties;

	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(DesignApiForServerAppApplication.class, args);
//		PersonRepository personRepository = context.getBean(PersonRepository.class);
//		PersonService personService = context.getBean(PersonService.class);
//		personService.updatePerson(1L,  "updated", 25);
		ReaderProperties readerProperties = context.getBean(ReaderProperties.class);
		log.info("maxAllowed: {}", readerProperties.getMaxAllowedBook());

	}

	@EventListener(ApplicationReadyEvent.class)
	public void onApplicationReady() {
		Person person = preparePerson();
        try {
            service.updatePerson(person.getId(), "updated", 25);
        } catch (Exception e) {
			System.err.println(e.getMessage());;
        }

        repository.findById(person.getId()).ifPresent(System.out::println);
	}

	private void doUpdate() {
		Person person = preparePerson();
	}

	private Person preparePerson(){
		Person person = new Person();
		person.setId(1L);
		person.setName("Initial");
		person.setAge(50);
		return repository.save(person);
	}



}
