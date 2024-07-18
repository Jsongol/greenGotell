package com.green.greenGotell.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductMiddleCategory {
    // CLOTHING
    MENS_CLOTHING("남성 의류", ProductCategory.CLOTHING),
    WOMENS_CLOTHING("여성 의류", ProductCategory.CLOTHING),
    KIDS_CLOTHING("아동 의류", ProductCategory.CLOTHING),
    // FOOD
    FRESH_FOOD("신선 식품", ProductCategory.FOOD),
    PROCESSED_FOOD("가공 식품", ProductCategory.FOOD),
    SEASONING("조미료", ProductCategory.FOOD),
    // KITCHENWARE
    COOKING_TOOLS("조리 도구", ProductCategory.KITCHENWARE),
    TABLEWARE("식기", ProductCategory.KITCHENWARE),
    KITCHEN_APPLIANCES("주방 가전", ProductCategory.KITCHENWARE),
    // HOUSEHOLD
    CLEANING_SUPPLIES("청소 용품", ProductCategory.HOUSEHOLD),
    LAUNDRY_SUPPLIES("세탁 용품", ProductCategory.HOUSEHOLD),
    BATHROOM_SUPPLIES("욕실 용품", ProductCategory.HOUSEHOLD),
    // INTERIOR
    FURNITURE("가구", ProductCategory.INTERIOR),
    LIGHTING("조명", ProductCategory.INTERIOR),
    DECORATIONS("장식품", ProductCategory.INTERIOR),
    // ELECTRONICS
    HOME_APPLIANCES("가전 제품", ProductCategory.ELECTRONICS),
    DIGITAL_DEVICES("디지털 기기", ProductCategory.ELECTRONICS),
    AUDIO_DEVICES("음향 기기", ProductCategory.ELECTRONICS),
    // STATIONERY_OFFICE
    STATIONERY("문구류", ProductCategory.STATIONERY_OFFICE),
    OFFICE_SUPPLIES("오피스 용품", ProductCategory.STATIONERY_OFFICE),
    COMPUTER_SUPPLIES("컴퓨터 용품", ProductCategory.STATIONERY_OFFICE),
    // SPORTS
    EXERCISE_EQUIPMENT("운동 기구", ProductCategory.SPORTS),
    SPORTS_CLOTHING("스포츠 의류", ProductCategory.SPORTS),
    OUTDOOR_ACTIVITIES("야외 활동", ProductCategory.SPORTS),
    // OTHERS
    TRAVEL_SUPPLIES("여행 용품", ProductCategory.OTHERS),
    PET_SUPPLIES("애완용품", ProductCategory.OTHERS),
    HEALTH_SUPPLIES("건강 용품", ProductCategory.OTHERS),
    HOBBY_SUPPLIES("취미 용품", ProductCategory.OTHERS);
	
	private final String displayName;
	private final ProductCategory productCategory;
	
}
