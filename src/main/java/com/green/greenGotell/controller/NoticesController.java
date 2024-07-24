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
	
	private final NoticeService service;
	
	// 공지사항 전체 게시글 조회
    @GetMapping
    public String list() {
        return "redirect:/notices/0/1"; // 페이지 번호 추가
    }

    // 공지사항 부서별 게시글 조회
    @GetMapping("/{division}/{page}")
    public String list(@PathVariable("division") int division, @PathVariable("page") int page, Model model) {
        service.listProcess(division, page, model);
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

