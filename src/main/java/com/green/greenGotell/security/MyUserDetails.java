package com.green.greenGotell.security;

import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.green.greenGotell.domain.entity.EmployeesEntity;

import lombok.Getter;

@Getter
public class MyUserDetails implements UserDetails{

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private Collection<GrantedAuthority> authorities;
	
	private String email;	//=username
	private String name;	//한글이름
	
	public MyUserDetails(EmployeesEntity entity) {
		username=entity.getEmail();
		password=entity.getPass();
		authorities=entity.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority("ROLE_" + role))
			    .collect(Collectors.toSet());
	
		email=entity.getEmail();
		name=entity.getName();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
