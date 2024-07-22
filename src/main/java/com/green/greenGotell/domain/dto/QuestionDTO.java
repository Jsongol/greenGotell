package com.green.greenGotell.domain.dto;

import lombok.Data;

@Data
public class QuestionDTO {

	private long key;//nanotime을 적용:질문자를 구분하기위한 값
	private String content;//질문내용
	private String name; //질문자-선택사항
}
