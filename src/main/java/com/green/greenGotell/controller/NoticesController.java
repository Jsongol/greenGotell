package com.green.greenGotell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticesController {

	@GetMapping("/notices")
	public String list() {
		
		return "/views/notices/list";
	}

}
