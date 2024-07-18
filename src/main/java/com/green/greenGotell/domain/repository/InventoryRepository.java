package com.green.greenGotell.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.green.greenGotell.domain.entity.InventoryEntity;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Long>{
	
}
