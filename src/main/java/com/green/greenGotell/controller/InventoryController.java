package com.green.greenGotell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.greenGotell.domain.dto.ProductSaveDTO;
import com.green.greenGotell.domain.entity.InventoryEntity;
import com.green.greenGotell.service.InventoryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

	private final InventoryService inventoryService;

	@GetMapping
	public String itemList() {
		return "/views/inventory/item-list";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("inventory", new InventoryEntity());
		return "/views/inventory/item-write";
	}

	@PostMapping("/inventory-add")
	public String addInventory(ProductSaveDTO dto, @RequestParam String productCategory,
			@RequestParam String productMiddleCategory, @RequestParam String productSmallCategory) {
		inventoryService.saveProcess(dto);
		return "redirect:/inventory";
	}

}
