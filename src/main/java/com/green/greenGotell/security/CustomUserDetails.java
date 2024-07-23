package com.green.greenGotell.security;

import java.util.stream.Collectors;

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
		super(entity.getEmail(),entity.getPass(),
				entity.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority("ROLE_" + role))
			    .collect(Collectors.toSet()));
		
		email=entity.getEmail();
		name=entity.getName();
		department=entity.getDepartment();
		id=entity.getId();
	}
	
}