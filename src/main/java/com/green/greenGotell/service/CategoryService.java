package com.green.greenGotell.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.greenGotell.domain.entity.Category;
import com.green.greenGotell.domain.repository.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoryService {
	@Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public Category createCategory(String name, Category.CategoryLevel level, Long parentId) {
        Category category = new Category();
        category.setName(name);
        category.setLevel(level);

        if (parentId != null) {
            Category parent = categoryRepository.findById(parentId)
                .orElseThrow(() -> new RuntimeException("Parent category not found"));
            category.setParent(parent);
            parent.getChildren().add(category);
        }

        return categoryRepository.save(category);
    }

    public List<Category> getLargeCategories() {
        return categoryRepository.findByParentIsNull();
    }

    public List<Category> getSubcategories(Long parentId) {
        return categoryRepository.findByParentId(parentId);
    }

}
