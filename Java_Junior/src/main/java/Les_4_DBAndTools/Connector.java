package Les_4_DBAndTools;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Connector {
    private final StandardServiceRegistry registry;
    private SessionFactory sessionFactory;

    public Connector() {
        registry = new StandardServiceRegistryBuilder()
                .configure() // считывает настройки из hibernate.cfg.xml
                .build();

        sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
