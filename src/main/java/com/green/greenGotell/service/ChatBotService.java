package com.green.greenGotell.service;

import com.green.greenGotell.domain.dto.QuestionDTO;

public interface ChatBotService {
	
	String processQuestion(QuestionDTO dto);
}
