package com.green.greenGotell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@Controller
public class PersonnelController {
	
	@GetMapping("/personnel")
	public String list() {
		
		return "/views/personnel/list";
	}
	
	@GetMapping("/personnel/write")
	public String write() {
		return "/views/personnel/write";
	}
	
	@GetMapping("/personnel/{no}")
	public String detail(@PathVariable("no") long no) {
		return "/views/personnel/detail";
	}
	
	@PutMapping("/personnel/{no}")
	public String update(@PathVariable("no") long no) {
		return "/redirect:/personnel";
	}
	
	

}
