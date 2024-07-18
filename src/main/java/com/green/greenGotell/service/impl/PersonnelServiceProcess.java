package com.green.greenGotell.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.green.greenGotell.domain.dto.CreateEmployeeDTO;
import com.green.greenGotell.domain.repository.EmployeesEntityRepository;
import com.green.greenGotell.service.PersonnelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PersonnelServiceProcess implements PersonnelService {

	private final EmployeesEntityRepository rep;
	private final PasswordEncoder pe;
	
	@Override
	public void createEmployee(CreateEmployeeDTO dto) {
		
		rep.save(dto.toEntity(pe));
		
	}

}
