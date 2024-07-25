package com.green.greenGotell.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private final CustomUserDetailService customUserDetailService; //사용자 세부 정보를 로드하는 서비스 객체생성
	private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	//사용자 인증이 성공했을 때 실행되는 핸들러입니다.
	//사용자가 로그인에 성공하면 특정 로직을 수행하고, 사용자를 적절한 페이지로 리다이렉트합니다.

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				//.csrf(csrf -> csrf.disable()) // CSRF 보호 비활성화 (개발 환경에서만 사용 권장)
				//.csrf(Customizer.withDefaults()) // 기본적으로 CSRF 보호 활성화 (추천)
				.authorizeHttpRequests(
						authorize -> authorize
						.requestMatchers("/css/**", "/js/**", "/images/**","/webjars/**","/favicon.ico*").permitAll() // 인증 없이
						.requestMatchers("/login").permitAll() // 인증 없이 접속 가능
						//.requestMatchers("/").permitAll() // 인증 없이 접속 가능
						//.requestMatchers("/emp/*").hasRole("EMP") // 특정 권한을 요구하는 URL
						// .requestMatchers("/hr/*").hasRole("HR") // 특정 권한을 요구하는 URL (주석 해제 시 사용)
						// .requestMatchers("/admin/*").hasRole("ADMIN") // 특정 권한을 요구하는 URL (주석 해제 시 사용)
						.anyRequest().authenticated() // 위 설정을 제외한 나머지는 인증 필요 (항상 마지막에 위치)
				).formLogin(login -> login
						.loginPage("/login") // 로그인 페이지 URL
						//.loginProcessingUrl("/login") // 로그인 처리 URL (form action과 일치하도록 설계 필요)
						.permitAll() // 로그인 페이지 접근 허용
						.usernameParameter("email") // 사용자 이름 파라미터 이름 설정 (기본값: username)
						.passwordParameter("pass") // 비밀번호 파라미터 이름 설정 (기본값: password)
						.successHandler(customAuthenticationSuccessHandler) // 로그인 성공 이후 처리할 내용을 정의
				).logout(logout -> logout.logoutSuccessUrl("/") // 로그아웃 성공 후 이동할 URL
						.logoutUrl("/logout") // 로그아웃 URL 명시적으로 설정
						.logoutSuccessUrl("/") // 로그아웃 성공 후 이동할 URL
						.invalidateHttpSession(true) // 세션 무효화
						.permitAll() // 로그아웃 URL 접근 허용
				).userDetailsService(customUserDetailService); // 사용자 세부 정보를 로드하는 서비스 설정

		return http.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(14);
	}
}