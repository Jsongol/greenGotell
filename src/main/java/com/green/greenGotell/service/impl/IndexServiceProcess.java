package com.green.greenGotell.service.impl;

import org.springframework.stereotype.Service;

import com.green.greenGotell.domain.repository.EmployeePhotoEntityRepository;
import com.green.greenGotell.security.CustomUserDetails;
import com.green.greenGotell.service.IndexService;

import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class IndexServiceProcess implements IndexService {
	
	
	private final EmployeePhotoEntityRepository employeePhotoEntityRepository;
	
	
	


	@Override
	public void list(CustomUserDetails userDetails, org.springframework.ui.Model model) {
	
		
		
		model.addAttribute("ProfilePhoto",employeePhotoEntityRepository.findByEmployeeId(userDetails.getId()).orElseThrow().toProfileImageDTO() );
	
		
	}

}
