package ru.Goncharov.Sem_7_Spring_Security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import java.util.*;
import java.util.stream.Collectors;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(source -> {
            Map<String, Object> resourceAccess = source.getClaim("realm_access");
            List<String> roles = (List<String>) resourceAccess.get("roles");

            return roles.stream()
                    .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        });

        return httpSecurity
                .authorizeHttpRequests(registry->registry.
                        requestMatchers("/api/resource").permitAll(). // Разрешаем только корень ресурса всем
                                anyRequest().authenticated() // Все остальные пути (включая /admin, /user, /auth) требуют логина
                )
                //.formLogin(Customizer.withDefaults()).
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwtConfigurer -> jwtConfigurer.
                                jwtAuthenticationConverter(converter))
                )
                .build();

    }

}
