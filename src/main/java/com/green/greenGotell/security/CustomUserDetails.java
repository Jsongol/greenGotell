package com.green.greenGotell.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.green.greenGotell.domain.entity.EmployeesEntity;
import com.green.greenGotell.domain.enums.Department;

import lombok.Getter;

@Getter	//prinsipal 에서 확인 가능, 인증정보에 prinsipal 객체에 저장
public class CustomUserDetails extends User{
	
	private static final long serialVersionUID = 1L; // 2L 버전정보를 교체
	//principal에서 확인하기 위해 추가로 등록할 수 있다.
	private Long id;
	private String email;	//=username
	private String name;	//한글이름
	private Department department;
	
	
	public CustomUserDetails(EmployeesEntity entity) {
		super(entity.getEmail(), entity.getPass(), getAuthorities(entity));
//		super(entity.getEmail(),entity.getPass(),
//				entity.getRoles().stream()
//				.map(role -> new SimpleGrantedAuthority("ROLE_" + role))
//			    .collect(Collectors.toSet()));
		
		email=entity.getEmail();
		name=entity.getName();
		department=entity.getDepartment();
		id=entity.getId();
	}
	private static Set<GrantedAuthority> getAuthorities(EmployeesEntity entity) {
		Set<GrantedAuthority> authorities = entity.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority("ROLE_" + role))
				.collect(Collectors.toSet());

		// 부서 정보를 권한에 추가
		authorities.add(new SimpleGrantedAuthority("DEPT_" + entity.getDepartment().name()));
		return authorities;
	}
	
}