package DZ_3.Task_2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class PersonRepository {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonPU");

    // 1. Добавление (Create)
    public void addPerson(Person person) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
    }

    // 2. Поиск по ID (Read)
    public Person findById(int id) {
        EntityManager em = emf.createEntityManager();
        Person person = em.find(Person.class, id);
        em.close();
        return person;
    }

    // 3. Обновление (Update)
    public void updatePerson(Person person) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(person); // Обновляет существующий объект
        em.getTransaction().commit();
        em.close();
    }

    // 4. Удаление (Delete)
    public void deletePerson(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        if (person != null) {
            em.remove(person);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Person> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Person> persons = em.createQuery("FROM Person", Person.class).getResultList();
        em.close();
        return persons;
    }

    public void close() { emf.close(); }
}
