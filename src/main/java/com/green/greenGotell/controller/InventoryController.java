package com.green.greenGotell.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.greenGotell.domain.dto.ProductSaveDTO;
import com.green.greenGotell.domain.entity.InventoryEntity;
import com.green.greenGotell.domain.enums.ProductCategory;
import com.green.greenGotell.domain.enums.ProductMiddleCategory;
import com.green.greenGotell.domain.enums.ProductSmallCategory;
import com.green.greenGotell.domain.enums.Standard;
import com.green.greenGotell.service.InventoryService;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {
<<<<<<< HEAD
=======
	
	@GetMapping("/inventory")
	public String list() {
		return "/views/inventory/list";
	}
	@GetMapping("/inventory-add")
	public String add() {
		return "/views/inventory/write";
	}
>>>>>>> f70f3f4dbed41890df806b6d33a86948c2f9f429

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
    public String addInventory(ProductSaveDTO dto) {
        inventoryService.saveProcess(dto);
        return "redirect:/inventory";
    }
}
