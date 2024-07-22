package com.green.greenGotell.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.green.greenGotell.domain.dto.CategoryDTO;
import com.green.greenGotell.domain.entity.CategoryEntity;
import com.green.greenGotell.domain.repository.CategoryRepository;
import com.green.greenGotell.security.CategoryNotFoundException;
import com.green.greenGotell.service.CategoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceProcess implements CategoryService {

	private final CategoryRepository repository;

	@Override
    @Transactional(readOnly = true)
    public List<CategoryDTO> getAll() {
        log.info("Fetching all root categories");
        List<CategoryEntity> rootCategories = repository.findByParentIsNull();
        return rootCategories.stream()
            .map(CategoryDTO::fromEntity)
            .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Long save(String name, Long parentId) {
        log.info("Saving category with name: {}", name);
        CategoryEntity parent = null;
        int level = 0;

        if (parentId != null) {
            parent = repository.findById(parentId)
                .orElseThrow(() -> new CategoryNotFoundException("Parent category not found"));
            level = parent.getLevel() + 1;
        }

        CategoryEntity category = CategoryEntity.builder()
                .name(name)
                .parent(parent)
                .level(level)
                .build();
        
        CategoryEntity savedCategory = repository.save(category);
        return savedCategory.getId();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        log.info("Deleting category with id: {}", id);
        CategoryEntity category = repository.findById(id)
            .orElseThrow(() -> new CategoryNotFoundException("Category not found"));

        if (category.getChildren().isEmpty()) {
            repository.delete(category);
        } else {
            category.setName(category.getName() + " (삭제됨)");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDTO> findByParentIdAndLevel(Long parentId, int level) {
        log.info("Fetching categories with parentId: {} and level: {}", parentId, level);
        List<CategoryEntity> categories = repository.findByParentIdAndLevel(parentId, level);
        return categories.stream().map(CategoryDTO::fromEntity).collect(Collectors.toList());
    }
}
