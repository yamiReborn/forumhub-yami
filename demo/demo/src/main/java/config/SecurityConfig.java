package com.example.yami.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/admin/**").hasRole("ADMIN")  // Protege rotas que exigem a role ADMIN
                .requestMatchers("/user/**").hasRole("USER")    // Protege rotas que exigem a role USER
                .requestMatchers("/**").permitAll()              // Permite acesso público a todas as outras rotas
                .and()
                .formLogin()                                  // Configura formulário de login
                .and()
                .logout();                                    // Configura logout padrão
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Usando o BCrypt para codificação de senhas
    }

    @Bean
    public UserDetailsService userDetailsService() {
        User.UserBuilder users = User.withDefaultPasswordEncoder();  // Método simplificado para senha com codificação padrão
        return username -> users.username(username).password("password").roles("USER").build();  // Usuário fictício com senha "password" e role "USER"
    }
}
