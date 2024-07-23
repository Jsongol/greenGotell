package com.green.greenGotell.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.green.greenGotell.domain.dto.CreateEmployeeDTO;
import com.green.greenGotell.security.CustomUserDetails;
import com.green.greenGotell.service.PersonnelService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class PersonnelController {
	
	private final PersonnelService personnelService;
	
	@GetMapping("/login")
	public String getMethodName() {
		
		return "/login";
	}
	
	


	@GetMapping("/personnel")
	public String list(Model model) {
		
		personnelService.showEmployeeList(model);
		
		return "/views/personnel/employee/list";
	}
	
	
	@PostMapping("/personnel/create")
	public String create(CreateEmployeeDTO dto) {
		personnelService.createEmployee(dto);
		
		return "redirect:/personnel";
	}
	

	
	
	
	
	
}
