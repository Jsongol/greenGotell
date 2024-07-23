package com.green.greenGotell.controller;

import java.text.MessageFormat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.green.greenGotell.domain.dto.QuestionDTO;
import com.green.greenGotell.service.KomoranService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ChatBotController {

	private final SimpMessagingTemplate messagingTemplate;
	private final KomoranService komoranService;

	@MessageMapping("/question") // '/bot/question'
	public void bot(QuestionDTO dto) {
		if (dto.getContent().startsWith("category:")) {
            String category = dto.getContent().substring(9); // 카테고리 키워드 추출
            String response = handleCategory(category);
            messagingTemplate.convertAndSend("/topic/bot/" + dto.getKey(), response);
        } else {
            // 형태소 분석기 또는 다른 처리를 위한 코드
		komoranService.nlpProcess(dto.getContent());
        }
	}

	@MessageMapping("/hello") // '/bot/question'
	public void hello(QuestionDTO dto) {
		long key = dto.getKey();
		String pattern = "{0}님 안녕하세요!";
		messagingTemplate.convertAndSend("/topic/bot/" + key, 
				MessageFormat.format(pattern, dto.getName()));
	}
	
	private String handleCategory(String category) {
        // 카테고리에 따라 다른 응답 생성
        switch (category) {
            case "findPerson":
                return "찾는 사람에 대해 질문하세요.";
            case "schedule":
                return "스케줄 관련 정보를 확인하세요.";
            case "changeInfo":
                return "정보 변경을 위한 방법을 안내합니다.";
            case "notice":
                return "공지사항을 확인하세요.";
            default:
                return "유효하지 않은 카테고리입니다.";
        }
    }
}