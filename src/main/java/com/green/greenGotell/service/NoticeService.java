package com.green.greenGotell.service;

import org.springframework.ui.Model;

import com.green.greenGotell.domain.dto.NoticeSaveDTO;
import com.green.greenGotell.domain.dto.NoticeUpdateDTO;
import com.green.greenGotell.security.CustomUserDetails;

public interface NoticeService {

	void listProcess(int division, int page, Model model);

	void saveProcess(Long id, NoticeSaveDTO dto);
	void saveProcess(CustomUserDetails userDetails, NoticeSaveDTO dto);

	void detailProcess(CustomUserDetails userDetails, long no, Model model);

	void updateProcess(long no, NoticeUpdateDTO dto);

	void deleteProcess(long no);

	

}
