package com.green.greenGotell.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemSearchDTO {
	
	private String name;
	private String category;
	
	public boolean isEmpty() {
		return category==null && (name == null || name.trim().isEmpty());
		
	}

}
