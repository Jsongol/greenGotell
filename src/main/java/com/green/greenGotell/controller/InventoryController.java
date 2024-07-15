package com.green.greenGotell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class InventoryController {
	
	@GetMapping("/inventory")
	public String itemList() {
		return "/views/inventory/item-list";
	}
	@GetMapping("/inventory-add")
	public String itemAdd() {
		return "/views/inventory/item-write";
	}
	@GetMapping("/item")
	public String list() {
		return "/views/inventory/list";
	}
	@GetMapping("/item-write")
	public String add() {
		return "/views/inventory/write";
	}
}
