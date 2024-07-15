package com.green.greenGotell.chatbot;

import java.text.MessageFormat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;

import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
public class BotController {

		private final SimpMessagingTemplate messagingTemplate;
		private final KomoranService komoranService;
		
		@GetMapping("/chatbot")
		public String list() {
			return "/views/chatbot/list";
		}
		
		@MessageMapping("/question") 
		public void bot(Question dto) {
			System.out.println(">>>:"+dto);
			komoranService.nlpProcess(dto.getContent());
		}
		
		@MessageMapping("/hello") 
		public void hello(Question dto) {
			System.out.println(">>>:"+dto);
			long key = dto.getKey();
			String pattern = "{0}님 안녕하세요!";
			
			messagingTemplate.convertAndSend("/topic/bot/"+key, 
					MessageFormat.format(pattern, dto.getName())
					);
		}
		
}