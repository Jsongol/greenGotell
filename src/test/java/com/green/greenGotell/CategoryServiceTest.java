package com.green.greenGotell;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.green.greenGotell.domain.dto.CategoryDTO;
import com.green.greenGotell.service.CategoryService;

@SpringBootTest
public class CategoryServiceTest {
	
	@Autowired
    private CategoryService categoryService;

	@Test
    @Transactional
    public void testCategoryInsertionAndRetrieval() {
        // Given
        Long clothingId = categoryService.save("의류", null);

        // When
        Long mensClothingId = categoryService.save("남성 의류", clothingId);
        categoryService.save("정장", mensClothingId);
        categoryService.save("캐주얼", mensClothingId);
        categoryService.save("스포츠웨어", mensClothingId);
        categoryService.save("수영복", mensClothingId);

        Long womensClothingId = categoryService.save("여성 의류", clothingId);
        categoryService.save("드레스", womensClothingId);
        categoryService.save("캐주얼", womensClothingId);
        categoryService.save("스포츠웨어", womensClothingId);
        categoryService.save("수영복", womensClothingId);

        Long kidsClothingId = categoryService.save("아동 의류", clothingId);
        categoryService.save("정장", kidsClothingId);
        categoryService.save("캐주얼", kidsClothingId);
        categoryService.save("스포츠웨어", kidsClothingId);
        categoryService.save("수영복", kidsClothingId);

        // Then
        @SuppressWarnings("unchecked")
		List<CategoryDTO> rootCategories = (List<CategoryDTO>) categoryService.getAll();
        assertEquals(1, rootCategories.size());
        assertEquals("의류", rootCategories.get(0).getName());

        List<CategoryDTO> mensCategories = categoryService.findByParentIdAndLevel(clothingId, 1);
        assertEquals(3, mensCategories.size());
        assertTrue(mensCategories.stream().anyMatch(category -> category.getName().equals("남성 의류")));
        assertTrue(mensCategories.stream().anyMatch(category -> category.getName().equals("여성 의류")));
        assertTrue(mensCategories.stream().anyMatch(category -> category.getName().equals("아동 의류")));

        List<CategoryDTO> mensSubCategories = categoryService.findByParentIdAndLevel(mensClothingId, 2);
        assertEquals(4, mensSubCategories.size());
        assertTrue(mensSubCategories.stream().anyMatch(category -> category.getName().equals("정장")));
        assertTrue(mensSubCategories.stream().anyMatch(category -> category.getName().equals("캐주얼")));
        assertTrue(mensSubCategories.stream().anyMatch(category -> category.getName().equals("스포츠웨어")));
        assertTrue(mensSubCategories.stream().anyMatch(category -> category.getName().equals("수영복")));
    }
}

