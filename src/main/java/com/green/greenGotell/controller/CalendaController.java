package com.green.greenGotell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CalendaController {

	@GetMapping("/calendar")
	public String list() {
		return "views/calendar/list";
	}
	
}
