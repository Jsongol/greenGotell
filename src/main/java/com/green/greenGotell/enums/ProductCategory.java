package com.green.greenGotell.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductCategory {
	 CLOTHING("의류"),
	 FOOD("식품"),
	 KITCHENWARE("주방용품"),
	 HOUSEHOLD("생활용품"),
	 INTERIOR("인테리어"),
	 ELECTRONICS("가전 디지털"),
	 STATIONERY_OFFICE("문구/오피스"),
	 SPORTS("스포츠"),
	 OTHERS("기타");
	
	private final String displayName;
	
	public String getDisplayName() {
		return displayName;
	}
}
