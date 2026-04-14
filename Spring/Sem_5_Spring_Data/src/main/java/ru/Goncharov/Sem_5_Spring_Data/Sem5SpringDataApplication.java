package ru.Goncharov.Sem_5_Spring_Data;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.Goncharov.Sem_5_Spring_Data.model.User;
import ru.Goncharov.Sem_5_Spring_Data.repository.UserRepository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@SpringBootApplication
public class Sem5SpringDataApplication {

	/*
	JDBC (Java Database Connectivity) - библиотека внутри Java для работы с БД
	Driver, Connection, Statement... - основные

	JPA (Jakarta Persistence API) - набор соглашений по работе с реляционными моделями
	Основная задача - "замапить" вашу DB-модель на java-классы и работать со строками таблиц, как с объектами
	JPA - это не реализация, а протокол (api, спецификация)
	Hibernate - одна из реализаций JPA (еще одна реализация - EclipseLink)

	spring-data-jdbc - набор готовых инструментов для взаимодействия с БД
	По сути оборачивает стандартный JDBC и представляет удобные интерфейсы для настройки и взаимодействия с БД

	spring-data-jpa - набор готовых инструментов для работы с JPA
	*/

	public static void main(String[] args) {
		//SpringApplication.run(Sem5SpringDataApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(Sem5SpringDataApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);

		User user = new User();
		user.setId(1L);
		user.setName("Michael");
		userRepository.save(user);
		System.out.println(userRepository.findAllByName("Michael"));

//		//DataSource dataSource = context.getBean(DataSource.class);
//		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
//		jdbcTemplate.execute("CREATE TABLE USERS (id bigint, name varchar(512))");
//		jdbcTemplate.execute("INSERT INTO USERS (id, name) values (1, 'Igor')");
//
//		List<User> users = jdbcTemplate.query("SELECT id,name FROM USERS",
//				(rs, rowNum) -> new User(rs.getLong("id"), rs.getString("name")));
//
//		try (Connection connection = dataSource.getConnection()  ) {
//			try (Statement statement = connection.createStatement()) {
//				statement.execute(
//						"CREATE TABLE USERS (id bigint, name varchar(512))");
//			}
//			try (Statement statement = connection.createStatement()) {
//				statement.execute(
//						"insert into USERS (id, name) values (1, 'Igor')");
//			}
//
//			try (Statement statement = connection.createStatement()) {
//				ResultSet resultset = statement.executeQuery("SELECT id,name FROM USERS");
//				while (resultset.next()) {
//					System.out.println(resultset.getInt("id"));
//					System.out.println(resultset.getString("name"));
//				}
//			}
//		} catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//	@Data
//	@AllArgsConstructor
//	static class User {
//		private Long id;
//		private String name;
//	}

	}
}
