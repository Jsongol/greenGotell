package com.green.greenGotell.chatbot;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class BotController {

	@GetMapping("/chat")
	public String list() {
		return "/views/chat/index";
	}
	
	
}