package com.green.greenGotell.domain.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Getter
@Setter
public class PageRequestDTO {
	
	private int page=1;
	private int size=17;
	
	public Pageable getPageable(Sort sort) {
		return PageRequest.of(page -1, size ,sort);
		
	}
	

}
