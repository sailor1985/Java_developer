package Les_4_DBAndTools;

import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.List;

@NoArgsConstructor
public class Db {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static void con() throws SQLException {
/*        try (Connection con = DriverManager.getConnection(URL,USER,PASSWORD)) {
            Statement statement = con.createStatement();
            statement.execute("CREATE SCHEMA IF NOT EXISTS test");
            statement.execute("CREATE TABLE IF NOT EXISTS test.table (id INT NOT NULL, firstname VARCHAR(45) NUll, lastname VARCHAR(45) NULL, PRIMARY KEY (id));");
            //statement.execute("INSERT INTO test.table (id, firstname, lastname)\n" + "VALUES (1, 'Иванов', 'Иван');");
            statement.execute("INSERT INTO test.table (id, firstname, lastname)\n" + "VALUES (2, 'Петров', 'Петр');");

            ResultSet set = statement.executeQuery("SELECT * FROM test.table;");
            while (set.next()) {
                System.out.println(set.getString(3) + " " + set.getString(2) + " " + set.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/

/*        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();

        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Magic magic = new Magic("Волшебная стрела", 100, 0);
        session.beginTransaction();
        session.persist(magic);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();*/

        Connector connector = new Connector();

        // 1. Открываем сессию для записи данных
/*        try (Session session = connector.getSession()) {
            session.beginTransaction();

            // Создаем и сохраняем объекты (как в уроке)
            session.persist(new Magic("Волшебная стрела", 10, 0, 0));
            session.persist(new Magic("Молния", 25, 0, 0));
            session.persist(new Magic("Каменная кожа", 0, 0, 6));
            session.persist(new Magic("Жажда крови", 0, 6, 0));
            session.persist(new Magic("Проклятие", 0, -3, 0));
            session.persist(new Magic("Лечение", -30, 0, 0));

            session.getTransaction().commit();
            System.out.println("--- Данные успешно сохранены ---");
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        // 2. Открываем сессию (или продолжаем ту же) для чтения данных
/*        try (Session session = connector.getSession()) {
            List<Magic> list = session.createQuery("FROM Magic", Magic.class).getResultList();

            System.out.println("--- Список объектов из базы: ---");
            list.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }*/

        //3. Открываем сессию для изменения данных
/*        try (Session session = connector.getSession()) {
            String hql = "from Magic where id= :id";
            Query<Magic> query = session.createQuery(hql, Magic.class);
            query.setParameter("id",4);
            Magic magic = query.getSingleResult();
            System.out.println(magic);
            magic.setAttBonus(100);
            magic.setName("Ярость");
            session.beginTransaction();
            session.merge(magic);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        //4. Открываем сессию для удаления данных
        try (Session session = connector.getSession()) {
            Transaction t = session.beginTransaction();
            List<Magic> magics = session.createQuery("FROM Magic ", Magic.class).getResultList();
            magics.forEach(session::remove);
            t.commit();



        } catch (Exception e) {
            e.printStackTrace();
        }

       /* // Начинаем транзакцию перед сохранением объектов
        session.beginTransaction();

        Magic magic;

        magic = new Magic("Волшебная стрела", 10, 0, 0);
        session.persist(magic);

        magic = new Magic("Молния", 25, 0, 0);
        session.persist(magic);

        magic = new Magic("Каменная кожа", 0, 0, 6);
        session.persist(magic);

        magic = new Magic("Жажда крови", 0, 6, 0);
        session.persist(magic);

// На скриншоте эта строка дублируется
        magic = new Magic("Жажда крови", 0, 6, 0);
        session.persist(magic);

        magic = new Magic("Проклятие", 0, -3, 0);
        session.persist(magic);

        magic = new Magic("Лечение", -30, 0, 0);
        session.persist(magic);

// Дописываем то, что было обрезано: подтверждаем транзакцию
        session.getTransaction().commit();

// Закрываем сессию
        session.close();*/

    }
}