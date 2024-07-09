package com.green.greenGotell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ChatController {
	
	@GetMapping("/chat")
	public String list() {
		return "/views/chat/list";
	}
	
}
