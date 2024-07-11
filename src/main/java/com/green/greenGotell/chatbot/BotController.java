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
public class BotController {

	@GetMapping("/chatbot")
	public String list() {
		return "/views/chatbot/list";
	}
	
	
	@MessageMapping("/hello")
	@SendTo("/topic/Goting")
	public Goting greeting(HelloMessage message) throws Exception {
		System.out.println("클라이언트에서 이름을을 객체로 보냈어요>>>>"+message.getName());
		return new Goting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}
	
}