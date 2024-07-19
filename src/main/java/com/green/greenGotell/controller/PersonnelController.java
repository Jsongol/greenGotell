package com.green.greenGotell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.green.greenGotell.domain.dto.CreateEmployeeDTO;
import com.green.greenGotell.service.PersonnelService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class PersonnelController {
	
	private final PersonnelService personnelService;

	@GetMapping("/personnel")
	public String list() {
		return "/views/personnel/employee/list";
	}
	
	
	@PostMapping("/personnel/create")
	public String create(CreateEmployeeDTO dto) {
		System.out.println(dto.getHireDate());
		personnelService.createEmployee(dto);
		
		return "redirect:/personnel";
	}
	
	
	@GetMapping("/mypage")
	public String mypage() {
		return "/views/personnel/employee/mypage";
	}
	
	
	
	
	
}
