package com.green.greenGotell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.greenGotell.domain.dto.NoticeSaveDTO;
import com.green.greenGotell.domain.dto.NoticeUpdateDTO;
import com.green.greenGotell.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/notices")
@RequiredArgsConstructor
@Controller
public class NoticesController {
	
	//공지사항 서비스 생성(DI)
	private final NoticeService service;
	
	//공지사항 게시판 클릭시("/notices") 전체+부서별 모든 게시판항목 출력
	@GetMapping
	public String list() {
		return "redirect:/notices/0";
	}
	
	//부서별 공지사항 출력
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
	
	//공지사항 만들기
	@GetMapping("/new")
	public String write() {
		return "views/notices/write";
	}

	//상세페이지 조회
	@GetMapping("/detail/{no}")
	public String detail(@PathVariable("no") long no, Model model) {	
		service.detailProcess(no, model);
		return "views/notices/detail";
	}
	
	//상세페이지 수정
	@PutMapping("/{no}")
	public String update(@PathVariable("no")long no, NoticeUpdateDTO dto) {	
		service.updateProcess(no, dto);
		return "redirect:/notices/detail/{no}";
	}

	//해당 공지사항 삭제
	@DeleteMapping("/{no}")
	public String delete(@PathVariable("no") long no) {
		service.deleteProcess(no);
		return "redirect:/notices";
	}
	
	
}

