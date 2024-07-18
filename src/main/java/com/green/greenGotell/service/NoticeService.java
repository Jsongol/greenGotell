package com.green.greenGotell.service;

import org.springframework.ui.Model;

import com.green.greenGotell.domain.dto.NoticeSaveDTO;

public interface NoticeService {

	void listProcess(int division, Model model);

	void saveProcess(NoticeSaveDTO dto);

}
