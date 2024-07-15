package com.green.greenGotell.chatbot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;

@Configuration
public class KomoranConfig {


	@Bean
	Komoran komoran() {
		Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
		return komoran;
	}
}