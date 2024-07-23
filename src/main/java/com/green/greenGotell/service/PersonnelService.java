package com.green.greenGotell.service;

import org.springframework.ui.Model;

import com.green.greenGotell.domain.dto.CreateEmployeeDTO;
import com.green.greenGotell.security.CustomUserDetails;

public interface PersonnelService{

	void createEmployee(CreateEmployeeDTO dto);

	void showEmployeeList(Model model);
	
	

	

}
