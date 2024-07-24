package com.green.greenGotell.service;

import org.springframework.ui.Model;

import com.green.greenGotell.domain.dto.NoticeSaveDTO;
import com.green.greenGotell.domain.dto.NoticeUpdateDTO;

public interface NoticeService {

	void listProcess(int division, int page, Model model);

	void saveProcess(NoticeSaveDTO dto);

	void detailProcess(long no, Model model);

	void updateProcess(long no, NoticeUpdateDTO dto);

	void deleteProcess(long no);

}
