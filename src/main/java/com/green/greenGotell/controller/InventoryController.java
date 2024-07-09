package com.green.greenGotell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class InventoryController {

	@GetMapping("/inventory")
	public String list() {
		return "/views/test/list";
	}
	
}
