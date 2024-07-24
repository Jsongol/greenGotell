package com.green.greenGotell.domain.entity;

import org.hibernate.annotations.DynamicUpdate;

import com.green.greenGotell.domain.dto.AnswerDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@DynamicUpdate
@Entity
@Table(name="answer")
public class AnswerEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int answerNo;
    
    @Column(columnDefinition = "varchar(30)")
    private String answerText;

    @ManyToOne
    @JoinColumn(name = "question_no")
    private QuestionEntity question;
    
    
}
