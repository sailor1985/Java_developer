package ru.Goncharov.Sem_5_Spring_Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 1. Конфигурация фильтров
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Отключаем CSRF для простоты (в реальных проектах лучше оставить и добавить токен в форму)
                .csrf(AbstractHttpConfigurer::disable)

                // Используем современный Lambda DSL для настройки
                .authorizeHttpRequests(auth -> auth
                        // Вместо antMatchers теперь используется requestMatchers
                        .requestMatchers("/public/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        // Указываем, куда переходить после успешного входа
                        .defaultSuccessUrl("/private", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login") // Куда идти после выхода
                        .permitAll()
                );

        return http.build();
    }

    // 2. Конфигурация пользователей (InMemory)
    @Bean
    public UserDetailsService userDetailsService() {
        // В современных версиях лучше явно указывать префикс кодировщика {noop} для простого текста
        UserDetails user = User.builder()
                .username("user")
                .password("{noop}password") // {noop} означает NoOpPasswordEncoder (без шифрования, для тестов)
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}