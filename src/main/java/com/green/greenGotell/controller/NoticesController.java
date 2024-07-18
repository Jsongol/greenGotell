package com.green.greenGotell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.greenGotell.domain.dto.NoticeSaveDTO;
import com.green.greenGotell.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/notices")
@RequiredArgsConstructor
@Controller
public class NoticesController {
	
	private final NoticeService service;
	
	@GetMapping
	public String list() {
		
		return "redirect:/notices/1";
	}
	
	@GetMapping("/{division}")
	public String list(@PathVariable("division") int division,Model model) {
		service.listProcess(division, model);
		return "views/notices/list";
	}
	
	//공지사항 저장하기
	@PostMapping
	public String save(NoticeSaveDTO dto) {
		
		service.saveProcess(dto);
		
		return "redirect:/notices";
	}
	
	@GetMapping("/new")
	public String write() {
		return "views/notices/write";
	}

//	@GetMapping("/{no}")
//	public String detail(@PathVariable("no") long no) {
//		return "/views/notices/detail";
//	}
}	
//	@PutMapping("/notices/{no}")
//	public String update(@PathVariable("no") long no) {
//		return "redirect:/notices";
//	}


