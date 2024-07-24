package com.green.greenGotell.service.impl;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.greenGotell.domain.dto.ItemDTO;
import com.green.greenGotell.domain.entity.CategoryEntity;
import com.green.greenGotell.domain.entity.ItemEntity;
import com.green.greenGotell.domain.repository.CategoryRepository;
import com.green.greenGotell.domain.repository.ItemRepository;
import com.green.greenGotell.service.ItemService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceProcess implements ItemService{
	private final ItemRepository itemrepository;
	private final CategoryRepository categoryRepository;
	
	@Override
	public void createItem(ItemDTO dto) {
		
        // 저장된 ItemEntity를 ItemDTO로 변환하여 반환
        itemrepository.save(dto.toEntity());
		
	}

	@Override
	public void list(Model model) {
		
		Sort sort = Sort.by(Direction.DESC,"id");
		
		//model.addAllAttributes("inventorys", )
		
	}
	
	
}
