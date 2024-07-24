package com.green.greenGotell.service;

import org.springframework.ui.Model;

import com.green.greenGotell.domain.dto.ItemDTO;

public interface ItemService {

	void createItem(ItemDTO dto);

	void list(Model model);

}
