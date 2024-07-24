package com.green.greenGotell.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.greenGotell.domain.entity.QuestionEntity;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Integer>{
	QuestionEntity findByCategory(String category);
}
