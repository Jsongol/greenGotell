package com.green.greenGotell.service;

import java.util.List;

import com.green.greenGotell.domain.dto.CategoryDTO;

public interface CategoryService {
	Object getAll();

	Long save(String name, Long parentId);

	void delete(Long id);

	List<CategoryDTO> findByParentIdAndLevel(Long parentId, int level);
}
