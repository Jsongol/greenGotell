package com.green.greenGotell.service.impl;

import org.springframework.stereotype.Service;

import com.green.greenGotell.domain.dto.QuestionDTO;
import com.green.greenGotell.domain.entity.AnswerEntity;
import com.green.greenGotell.domain.entity.QuestionEntity;
import com.green.greenGotell.domain.repository.AnswerRepository;
import com.green.greenGotell.domain.repository.QuestionRepository;
import com.green.greenGotell.service.ChatBotService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatBotServiceProcess implements ChatBotService {
	@Override
	public String processQuestion(QuestionDTO dto) {
		// 질문 번호를 가져옵니다.
		long questionNo = dto.getQuestionNo();

		// 질문 내용을 가져옵니다.
		String questionText = dto.getQuestionText();

		// 질문 처리 로직을 구현합니다.
		// 예를 들어, 질문 내용을 기반으로 응답을 생성할 수 있습니다.
		String response = generateResponse(questionText);

		return response;
	}

	private String generateResponse(String questionText) {
		// 간단한 예제 응답 생성 로직입니다.
		// 실제 애플리케이션에서는 더 복잡한 로직이나 외부 API 호출을 포함할 수 있습니다.

		if (questionText.contains("안녕하세요")) {
			return "안녕하세요! 어떻게 도와드릴까요?";
		} else if (questionText.contains("날씨")) {
			return "오늘의 날씨는 맑습니다.";
		} else if (questionText.contains("시간")) {
			return "현재 시간은 " + java.time.LocalTime.now().toString() + "입니다.";
		} else {
			return "죄송합니다, 이해하지 못했습니다.";
		}
	}
}
