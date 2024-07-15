package com.green.greenGotell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class NoticesController {
	
	@GetMapping("/notices")
	public String list() {
		return "views/notices/list";
	}
	
	@GetMapping("/new")
	public String write() {
		return "/views/notices/write";
	}
}
//	@GetMapping("/notices/{no}")
//	public String detail(@PathVariable("no") long no) {
//		return "/views/notices/detail";
//	}
//	
//	@PutMapping("/notices/{no}")
//	public String update(@PathVariable("no") long no) {
//		return "redirect:/notices";
//	}


