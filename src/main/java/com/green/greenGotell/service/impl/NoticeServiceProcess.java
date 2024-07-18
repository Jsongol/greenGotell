package com.green.greenGotell.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.greenGotell.domain.dto.NoticeSaveDTO;
import com.green.greenGotell.domain.repository.NoticeEntityRepository;
import com.green.greenGotell.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeServiceProcess implements NoticeService{
	
	private final NoticeEntityRepository repository;

	@Override
	public void listProcess(int division, Model model) {
		
		
	}

	@Override
	public void saveProcess(NoticeSaveDTO dto) {
		
		repository.save(dto.toEntity());
			
	}

}
