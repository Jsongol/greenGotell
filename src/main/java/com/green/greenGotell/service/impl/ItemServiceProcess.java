package com.green.greenGotell.service.impl;

import org.springframework.stereotype.Service;

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
	
}
