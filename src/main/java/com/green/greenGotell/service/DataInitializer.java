package com.green.greenGotell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.green.greenGotell.domain.entity.Category;

@Component
public class DataInitializer implements CommandLineRunner{
	
	@Autowired
    private CategoryService categoryService;

    @Autowired
    private ItemService itemService;

	@Override
	public void run(String... args) throws Exception {
		// 대분류 생성
        Category clothing = categoryService.createCategory("의류", Category.CategoryLevel.LARGE, null);

        // 중분류 생성
        Category menClothing = categoryService.createCategory("남성 의류", Category.CategoryLevel.MEDIUM, clothing.getId());
        Category womenClothing = categoryService.createCategory("여성 의류", Category.CategoryLevel.MEDIUM, clothing.getId());

        // 소분류 생성
        Category menSuit = categoryService.createCategory("정장", Category.CategoryLevel.SMALL, menClothing.getId());
        Category menSportswear = categoryService.createCategory("스포츠웨어", Category.CategoryLevel.SMALL, menClothing.getId());

        // 아이템 생성
        itemService.createItem("남성 정장 상의", menSuit.getId());
        itemService.createItem("남성 정장 하의", menSuit.getId());
        itemService.createItem("남성 운동복 상의", menSportswear.getId());
        itemService.createItem("남성 운동복 하의", menSportswear.getId());
		
	}

}
