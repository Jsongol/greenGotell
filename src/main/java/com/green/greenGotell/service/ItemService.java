package com.green.greenGotell.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.greenGotell.domain.entity.Category;
import com.green.greenGotell.domain.entity.Item;
import com.green.greenGotell.domain.repository.CategoryRepository;
import com.green.greenGotell.domain.repository.ItemRepository;

import jakarta.transaction.Transactional;

@Service
public class ItemService {
	@Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public Item createItem(String name, Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
            .orElseThrow(() -> new RuntimeException("Category not found"));

        Item item = new Item();
        item.setName(name);
        item.setCategory(category);

        return itemRepository.save(item);
    }

    public List<Item> getItemsByCategory(Long categoryId) {
        return itemRepository.findByCategoryId(categoryId);
    }

   
}
