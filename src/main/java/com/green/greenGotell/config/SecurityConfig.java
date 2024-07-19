package com.green.greenGotell.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setSessionAttributeName("_csrf");
        return repository;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.csrfTokenRepository(csrfTokenRepository()))
                .authorizeRequests(authorize -> authorize
                        .requestMatchers("/public/**").permitAll() // 인증 없이 접근 가능한 URL 패턴 설정
                        .requestMatchers("/admin/**").hasRole("ADMIN") // ADMIN 역할을 가진 사용자만 접근 가능한 URL 패턴 설정
                        .requestMatchers("/password-reset/**").permitAll() // 비밀번호 재설정 페이지에 대해 모든 사용자에게 접근 허용
                        .requestMatchers("/login").permitAll()
                        .anyRequest().authenticated() // 그 외 모든 요청은 인증이 필요함
                )
                .formLogin(login -> login
                        .loginPage("/login") // 로그인 페이지 URL 설정
                        .permitAll() // 로그인 페이지는 인증 없이 접근 가능한
                );

        return http.build();
    }
}
