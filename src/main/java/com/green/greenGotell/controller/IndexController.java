package com.green.greenGotell.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.green.greenGotell.domain.dto.NoticeListDTO;
import com.green.greenGotell.security.CustomUserDetails;
import com.green.greenGotell.service.IndexService;
import com.green.greenGotell.service.NoticeService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;



@RequiredArgsConstructor
@Controller
public class IndexController {
	
	private final IndexService indexService;
	private final NoticeService noticeService;
	
	
	  @GetMapping("/") public String getMethodName(@AuthenticationPrincipal
	  CustomUserDetails userDetails,Model model) {
	  
	  indexService.list(userDetails,model);
	  
	  // 최근 공지사항 목록을 모델에 추가
      List<NoticeListDTO> recentNotices = noticeService.getRecentNotices();
      model.addAttribute("recentNotices", recentNotices);
	 
	  return "index"; }
	
	
	

}
