package com.green.greenGotell.service;

import org.springframework.ui.Model;

import com.green.greenGotell.security.CustomUserDetails;



public interface IndexService {

	

	void list(CustomUserDetails userDetails, Model model);

}
