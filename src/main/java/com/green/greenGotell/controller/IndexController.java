package com.green.greenGotell.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.green.greenGotell.security.CustomUserDetails;
import com.green.greenGotell.service.IndexService;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;



@RequiredArgsConstructor
@Controller
public class IndexController {
	
	private final IndexService indexService;
	
	
	  @GetMapping("/") public String getMethodName(@AuthenticationPrincipal
	  CustomUserDetails userDetails,Model model) {
	  
	  indexService.list(userDetails,model);
	 
	  return "index"; }
	
	
	

}
