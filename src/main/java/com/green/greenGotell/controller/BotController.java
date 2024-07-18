package com.green.greenGotell.controller;



import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.green.greenGotell.chatbot.KomoranService;
import com.green.greenGotell.domain.entity.QuestionEntity;

import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
public class BotController {

		private final KomoranService komoranService;
		
		@GetMapping("/chatbot")
		public String list() {
			return "/views/chatbot/list";
		}
		
		@MessageMapping("/question") 
		public void bot(QuestionEntity dto) {
			System.out.println(">>>:"+dto);
			komoranService.nlpProcess(dto.getQuestion());
		}
		
		@MessageMapping("/hello") 
		public void hello(QuestionEntity dto) {
			System.out.println(">>>:"+dto);
			long questionNo = dto.getQuestionNo();
			String pattern = "{0}님 안녕하세요!";
			
		}
		
}