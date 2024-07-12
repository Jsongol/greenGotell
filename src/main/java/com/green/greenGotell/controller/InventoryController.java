package com.green.greenGotell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class InventoryController {
	
	@GetMapping("/inventory")
	public String list() {
		return "/views/inventory/list";
	}
	@GetMapping("/inventory-add")
	public String add() {
		return "/views/inventory/write";
	}

}
