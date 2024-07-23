package com.green.greenGotell.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.greenGotell.domain.entity.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Long>{

}
