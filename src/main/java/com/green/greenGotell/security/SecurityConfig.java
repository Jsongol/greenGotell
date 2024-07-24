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
	        
	        .headers(headers -> headers
	                .frameOptions(frameOptions -> frameOptions.sameOrigin())
	            )
	        
	        	//.csrf(csrf->csrf.disable())
	            //.csrf(Customizer.withDefaults())//명시하지않아도 기본으로 csrf 보안 적용-get요청 제외한
	            //토큰발행은 security가 해줍니다.
	        	//logout 할때 get이 아닌 post로 보내줘야한다.(로그아웃 할때도 토큰을 발행받아야 한다.)
	            //uri에 대한 보안
	        	/*
	            .authorizeHttpRequests(authorize -> authorize
	            		.requestMatchers("/css/**","/js/**","/images/**").permitAll()//인증없이 접속가능
	            		.requestMatchers("/","/signup","/boards","/login").permitAll()//인증없이 접속가능
	            		.requestMatchers("/emp/*","/boards/new").hasRole("EMP")	
	            		//.requestMatchers("/hr/*").hasRole("HR")	//Authorities=Role 권한을 확인한다.
	            		//.requestMatchers("/admin/*").hasRole("ADMIN")//admin은 admin권한 부여
	            		.requestMatchers("/","/signup").permitAll()
	            		
	            		//나머지 url은 로그인만 성공하면 접근가능 
	            		.anyRequest().authenticated() //위에 설정을 제외한 나머지는 인증이 필요합니다. anyRequest가 항상 마지막에 온다.
	            )
	            */
	        	.authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll())
	            //.httpBasic(Customizer.withDefaults())
	            
	            //Username And Password And 
	            .formLogin(login->login
	            		.loginPage("/login")//로그인페이지로 이동하는 url
	            		//.loginProcessingUrl("/login") //따로 요청을 설정할수 있다. form태그의 action과 일치하도록 post로 설계 해야한다
	            		.permitAll()//설정하지 않으면 에러가 뜰수 있습니다.
	            		
	            		.usernameParameter("email")//defalut=username
	            		.passwordParameter("pass")//defalut=password
	            		.successHandler(customAuthenticationSuccessHandler)//로그인 성공 이후 처리할 내용을 정의
	            		
	            )
	            .logout(logout->logout
	            		.logoutSuccessUrl("/")
	            		.invalidateHttpSession(true)
	            )
	            .userDetailsService(customUserDetailService)
	            ;
	        
	        return http.build();
	    }


		@Bean
		PasswordEncoder passwordEncoder() {
			
			return new BCryptPasswordEncoder(14);
			
		}

}
