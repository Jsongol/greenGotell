package com.green.greenGotell.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.green.greenGotell.domain.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	List<Category> findByParentIsNull();
    List<Category> findByParentId(Long parentId);
}
