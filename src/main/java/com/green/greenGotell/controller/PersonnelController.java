package com.green.greenGotell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class PersonnelController {

	@GetMapping("/personnel")
	public String list() {
		return "/views/personnel/employee/list";
	}
	
	@PostMapping("/personnel")
	public String write() {
		return new String();
	}
	
	
	@GetMapping("/mypage")
	public String mypage() {
		return "/views/personnel/employee/mypage";
	}
	
	
	
	
	
}
