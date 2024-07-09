package com.green.greenGotell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@Controller
public class InventoryController {

	@GetMapping("/inventory")
	public String list() {
		return "/views/test/list";
	}
	@GetMapping("/inventory/{no}")
	public String detail(@PathVariable("no") long no) {
		return "/views/test/detail";
	}
	@PutMapping("/inventory/{no}")
	public String update(@PathVariable("no") long no) {
		return "redirect:/test";
	}
	
}
