package com.green.greenGotell.service;

import org.springframework.ui.Model;

import com.green.greenGotell.domain.dto.PageRequestDTO;
import com.green.greenGotell.domain.dto.PageResultDTO;
import com.green.greenGotell.domain.dto.employee.CreateEmployeeDTO;
import com.green.greenGotell.domain.dto.employee.EmployeeListDTO;
import com.green.greenGotell.domain.dto.employee.EmployeeSearchDTO;
import com.green.greenGotell.domain.entity.EmployeesEntity;
import com.green.greenGotell.security.CustomUserDetails;

public interface PersonnelService{

	void createEmployee(CreateEmployeeDTO dto);


	EmployeeListDTO updatefindById(Long id);

	void updateEmployee(Long id, CreateEmployeeDTO employeeUpdateDTO);

	PageResultDTO<EmployeeListDTO, EmployeesEntity> showEmployeeList( PageRequestDTO pageDTO, EmployeeSearchDTO  searchDTO);


	

}
