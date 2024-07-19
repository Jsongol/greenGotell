package com.green.greenGotell.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.green.greenGotell.domain.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
	List<Item> findByCategoryId(Long categoryId);
}
