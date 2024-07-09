package com.green.greenGotell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ChatController {
	
	@GetMapping("/chat")
	public String list() {
		return "/views/chat/list";
	}
	
	@GetMapping("/caht/new")
	public String write() {
		return "/views/chat/wirte";
	}
	
	@GetMapping("/caht/{no}")
	public String detail(@PathVariable("no")long no) {
		return "/views/test/detail";
	}
	
}
