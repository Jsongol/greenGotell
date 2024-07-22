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

	//내부적으로 STOMP의 프로토콜을 사용하여 메세지를 전송
			//@SendTo 어노테이션을 처리하는 구현 객체
			private final SimpMessagingTemplate messagingTemplate;
			//private final RabbitTemplate rabbitTemplate;
			private final KomoranService komoranService;
			
			@MessageMapping("/question") // '/bot/question'
			public void bot(QuestionDTO dto) {
				System.out.println(">>>:"+dto);
				//들어온 메세지가 어떤 의도인지 파악 ---> 머신러닝(형태소 분석기를 통해 분석)
				komoranService.nlpProcess(dto.getContent());
			}
			
			@MessageMapping("/hello") // '/bot/question'
			//@SendTo("/topic/bot/"+key)//이렇게 SendTo에 바로 변수가 들어갈 수는 없음 -> ResponseBody와 같은 역할
			public void hello(QuestionDTO dto) {
				System.out.println(">>>:"+dto);
				long key = dto.getKey();
				String pattern = "{0}님 안녕하세요!";
				
				
				messagingTemplate.convertAndSend("/topic/bot/"+key, 
						MessageFormat.format(pattern, dto.getName())
						);
			}
		}