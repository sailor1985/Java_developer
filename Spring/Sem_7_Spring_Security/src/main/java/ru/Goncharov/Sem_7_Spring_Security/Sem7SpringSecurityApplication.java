package ru.Goncharov.Sem_7_Spring_Security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.Goncharov.Sem_7_Spring_Security.model.User;
import ru.Goncharov.Sem_7_Spring_Security.repository.UserRepository;


@SpringBootApplication
public class Sem7SpringSecurityApplication {

	//SecurityContext(SecurityContextHolder)
	//SecurityContextHolder = Map<String,SecurityContext>
	//Authoruzation - [Principle (login), List<GrantedAuthority> roles]
	//UserDetails -
	//UserDetailsService
	//SecirityFilterChain
	//PasswordEncoder

	static long id = 1L;
	public static void main(String[] args) {
		UserRepository userRepository = SpringApplication.run(Sem7SpringSecurityApplication.class, args).getBean(UserRepository.class);
		saveUser(userRepository, "admin");
		saveUser(userRepository, "user");
		saveUser(userRepository, "auth");
		saveUser(userRepository, "simple");
	}

	private  static void saveUser(UserRepository repository, String login) {
		User user = new User();
		user.setId(id++);
		user.setLogin(login);
		user.setPassword(login);
		user.setRole(login);
		repository.save(user);
	}

}
