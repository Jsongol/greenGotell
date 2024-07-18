package com.green.greenGotell.service.impl;


import org.springframework.stereotype.Service;

import com.green.greenGotell.domain.dto.ProductSaveDTO;
import com.green.greenGotell.domain.repository.InventoryRepository;
import com.green.greenGotell.service.InventoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryServiceProcess implements InventoryService{

	private final InventoryRepository inventoryRepository;

	@Override
	public void saveProcess(ProductSaveDTO dto) {
		inventoryRepository.save(dto.toEntity());
		
	}

	

   
}
