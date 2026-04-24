package ru.Goncharov.Sem_7_Spring_Security.security;

import org.jspecify.annotations.Nullable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public @Nullable String encode(@Nullable CharSequence rawPassword) {
        //Шифруем пароль
        return String.valueOf(rawPassword);
    }

    @Override
    public boolean matches(@Nullable CharSequence rawPassword, @Nullable String encodedPassword) {
        assert rawPassword != null;
        return Objects.equals(encode(rawPassword), encodedPassword);
    }
}
