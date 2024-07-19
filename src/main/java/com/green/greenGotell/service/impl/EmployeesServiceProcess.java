package com.green.greenGotell.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.green.greenGotell.domain.repository.EmployeesEntityRepository;
import com.green.greenGotell.service.EmployeesService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmployeesServiceProcess implements EmployeesService{

	private final EmployeesEntityRepository repository;
	private final PasswordEncoder pe;
	

}
