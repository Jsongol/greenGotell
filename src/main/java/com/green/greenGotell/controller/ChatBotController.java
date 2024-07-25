package com.green.greenGotell.controller;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.greenGotell.domain.dto.HelloDTO;
import com.green.greenGotell.domain.dto.QuestionDTO;
import com.green.greenGotell.service.ChatBotService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ChatBotController {

	private final SimpMessagingTemplate messagingTemplate;
    private final ChatBotService chatBotService;

    @GetMapping("/chatbot")
    public List<QuestionDTO> getCategory(@RequestParam("parent")int parent){
        return chatBotService.getCategoryByType(parent);
    }
    
    
    @MessageMapping("/hello")
    public void hello(HelloDTO dto) {
    	System.out.println(">>>:"+dto);
        long key = dto.getKey();
        String pattern = "{0}님 안녕하세요!";
        messagingTemplate.convertAndSend("/topic/bot/" + key, MessageFormat.format(pattern, dto.getName())
				);
	}

    @MessageMapping("/question")
    public void question(QuestionDTO dto) {   
    	
    }
}