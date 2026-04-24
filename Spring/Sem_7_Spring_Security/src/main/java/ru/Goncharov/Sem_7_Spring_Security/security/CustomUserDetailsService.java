package ru.Goncharov.Sem_7_Spring_Security.security;

import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.Goncharov.Sem_7_Spring_Security.repository.UserRepository;
import ru.Goncharov.Sem_7_Spring_Security.model.User;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username).
                orElseThrow(() -> new UsernameNotFoundException(username));


        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), List.of(
                new SimpleGrantedAuthority(user.getRole())
                ));

    }
}
