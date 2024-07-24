package com.green.greenGotell.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.greenGotell.domain.entity.AnswerEntity;
import com.green.greenGotell.domain.entity.QuestionEntity;

public interface AnswerRepository extends JpaRepository<AnswerEntity, Long>{
	AnswerEntity findByQuestion(QuestionEntity question);
}
