package DZ_4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory(); Session session = factory.getCurrentSession()) {

            Person person1 = new Person("Ivan", 25);
            Person person2 = new Person("Maria", 30);
            Person person3 = new Person("Alexey", 20);

            session.beginTransaction();

            System.out.println("Saving persons...");
            session.persist(person1);
            session.persist(person2);
            session.persist(person3);

            session.getTransaction().commit();

            System.out.println("Done! Persons saved successfully.");

        }
    }
}