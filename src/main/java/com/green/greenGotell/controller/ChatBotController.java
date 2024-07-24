package com.green.greenGotell.controller;

import java.text.MessageFormat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.green.greenGotell.domain.dto.QuestionDTO;
import com.green.greenGotell.service.ChatBotService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ChatBotController {

	private final SimpMessagingTemplate messagingTemplate;
    private final ChatBotService chatBotService;

    @GetMapping("/chatbot")
    public String chatbot() {
        return "/js/chatbot/chatbot";
    }
    
    
    @MessageMapping("/hello")
    public void hello(QuestionDTO dto) {
        long key = dto.getQuestionNo();
        String pattern = "{0}님 안녕하세요!";
        String formattedMessage = MessageFormat.format(pattern, dto.getQuestionText());
        messagingTemplate.convertAndSend("/topic/bot/" + key, formattedMessage);
    }

    @MessageMapping("/question")
    public void question(QuestionDTO dto) {
        long key = dto.getQuestionNo();
        String response = chatBotService.processQuestion(dto);
        messagingTemplate.convertAndSend("/topic/bot/" + key, response);
    }
}