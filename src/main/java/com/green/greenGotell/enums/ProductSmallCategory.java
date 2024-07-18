package com.green.greenGotell.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ProductSmallCategory {
	// MENS_CLOTHING
    SUIT("정장", ProductMiddleCategory.MENS_CLOTHING),
    CASUAL("캐주얼", ProductMiddleCategory.MENS_CLOTHING),
    SPORTSWEAR("스포츠웨어", ProductMiddleCategory.MENS_CLOTHING),
    SWIMWEAR("수영복", ProductMiddleCategory.MENS_CLOTHING),
    // WOMENS_CLOTHING
    DRESS("드레스", ProductMiddleCategory.WOMENS_CLOTHING),
    WOMENS_CASUAL("캐주얼", ProductMiddleCategory.WOMENS_CLOTHING),
    WOMENS_SPORTSWEAR("스포츠웨어", ProductMiddleCategory.WOMENS_CLOTHING),
    WOMENS_SWIMWEAR("수영복", ProductMiddleCategory.WOMENS_CLOTHING),
    // KIDS_CLOTHING
    KIDS_SUIT("정장", ProductMiddleCategory.KIDS_CLOTHING),
    KIDS_CASUAL("캐주얼", ProductMiddleCategory.KIDS_CLOTHING),
    KIDS_SPORTSWEAR("스포츠웨어", ProductMiddleCategory.KIDS_CLOTHING),
    KIDS_SWIMWEAR("수영복", ProductMiddleCategory.KIDS_CLOTHING),
    // FRESH_FOOD
    FRUIT("과일", ProductMiddleCategory.FRESH_FOOD),
    VEGETABLE("채소", ProductMiddleCategory.FRESH_FOOD),
    MEAT("육류", ProductMiddleCategory.FRESH_FOOD),
    SEAFOOD("해산물", ProductMiddleCategory.FRESH_FOOD),
    // PROCESSED_FOOD
    SNACK("스낵", ProductMiddleCategory.PROCESSED_FOOD),
    BEVERAGE("음료", ProductMiddleCategory.PROCESSED_FOOD),
    CANNED_FOOD("통조림", ProductMiddleCategory.PROCESSED_FOOD),
    FROZEN_FOOD("냉동식품", ProductMiddleCategory.PROCESSED_FOOD),
    // SEASONING
    SAUCE("소스", ProductMiddleCategory.SEASONING),
    SPICE("향신료", ProductMiddleCategory.SEASONING),
    SALT("소금", ProductMiddleCategory.SEASONING),
    SUGAR("설탕", ProductMiddleCategory.SEASONING),
    // COOKING_TOOLS
    POT("냄비", ProductMiddleCategory.COOKING_TOOLS),
    FRYING_PAN("프라이팬", ProductMiddleCategory.COOKING_TOOLS),
    KNIFE("칼", ProductMiddleCategory.COOKING_TOOLS),
    CUTTING_BOARD("도마", ProductMiddleCategory.COOKING_TOOLS),
    // TABLEWARE
    PLATE("접시", ProductMiddleCategory.TABLEWARE),
    CUP("컵", ProductMiddleCategory.TABLEWARE),
    BOWL("그릇", ProductMiddleCategory.TABLEWARE),
    SPOON("수저", ProductMiddleCategory.TABLEWARE),
    // KITCHEN_APPLIANCES
    MICROWAVE("전자레인지", ProductMiddleCategory.KITCHEN_APPLIANCES),
    BLENDER("믹서기", ProductMiddleCategory.KITCHEN_APPLIANCES),
    COFFEE_MACHINE("커피머신", ProductMiddleCategory.KITCHEN_APPLIANCES),
    TOASTER("토스터", ProductMiddleCategory.KITCHEN_APPLIANCES),
    // CLEANING_SUPPLIES
    VACUUM_CLEANER("청소기", ProductMiddleCategory.CLEANING_SUPPLIES),
    MOP("걸레", ProductMiddleCategory.CLEANING_SUPPLIES),
    DETERGENT("세제", ProductMiddleCategory.CLEANING_SUPPLIES),
    TRASH_CAN("쓰레기통", ProductMiddleCategory.CLEANING_SUPPLIES),
    // LAUNDRY_SUPPLIES
    WASHING_MACHINE("세탁기", ProductMiddleCategory.LAUNDRY_SUPPLIES),
    LAUNDRY_DETERGENT("세제", ProductMiddleCategory.LAUNDRY_SUPPLIES),
    FABRIC_SOFTENER("섬유유연제", ProductMiddleCategory.LAUNDRY_SUPPLIES),
    DRYING_RACK("빨래건조대", ProductMiddleCategory.LAUNDRY_SUPPLIES),
    // BATHROOM_SUPPLIES
    SHAMPOO("샴푸", ProductMiddleCategory.BATHROOM_SUPPLIES),
    SOAP("비누", ProductMiddleCategory.BATHROOM_SUPPLIES),
    TOWEL("수건", ProductMiddleCategory.BATHROOM_SUPPLIES),
    BATH_MAT("욕실매트", ProductMiddleCategory.BATHROOM_SUPPLIES),
    // FURNITURE
    BED("침대", ProductMiddleCategory.FURNITURE),
    SOFA("소파", ProductMiddleCategory.FURNITURE),
    TABLE("테이블", ProductMiddleCategory.FURNITURE),
    CHAIR("의자", ProductMiddleCategory.FURNITURE),
    // LIGHTING
    STAND("스탠드", ProductMiddleCategory.LIGHTING),
    CEILING_LIGHT("천장등", ProductMiddleCategory.LIGHTING),
    WALL_LIGHT("벽등", ProductMiddleCategory.LIGHTING),
    LED_LIGHT("LED 조명", ProductMiddleCategory.LIGHTING),
    // DECORATIONS
    PAINTING("그림", ProductMiddleCategory.DECORATIONS),
    VASE("화병", ProductMiddleCategory.DECORATIONS),
    CLOCK("시계", ProductMiddleCategory.DECORATIONS),
    CUSHION("쿠션", ProductMiddleCategory.DECORATIONS),
    // HOME_APPLIANCES
    TV("TV", ProductMiddleCategory.HOME_APPLIANCES),
    REFRIGERATOR("냉장고", ProductMiddleCategory.HOME_APPLIANCES),
    WASHING_MACHINE_APPLIANCE("세탁기", ProductMiddleCategory.HOME_APPLIANCES),
    AIR_CONDITIONER("에어컨", ProductMiddleCategory.HOME_APPLIANCES),
    // DIGITAL_DEVICES
    SMARTPHONE("스마트폰", ProductMiddleCategory.DIGITAL_DEVICES),
    TABLET("태블릿", ProductMiddleCategory.DIGITAL_DEVICES),
    LAPTOP("노트북", ProductMiddleCategory.DIGITAL_DEVICES),
    CAMERA("카메라", ProductMiddleCategory.DIGITAL_DEVICES),
    // AUDIO_DEVICES
    SPEAKER("스피커", ProductMiddleCategory.AUDIO_DEVICES),
    HEADPHONES("헤드폰", ProductMiddleCategory.AUDIO_DEVICES),
    EARPHONES("이어폰", ProductMiddleCategory.AUDIO_DEVICES),
    AMPLIFIER("앰프", ProductMiddleCategory.AUDIO_DEVICES),
    // STATIONERY
    PEN("펜", ProductMiddleCategory.STATIONERY),
    NOTEBOOK("노트", ProductMiddleCategory.STATIONERY),
    FILE("파일", ProductMiddleCategory.STATIONERY),
    STICKER("스티커", ProductMiddleCategory.STATIONERY),
    // OFFICE_SUPPLIES
    PRINTER("프린터", ProductMiddleCategory.OFFICE_SUPPLIES),
    COPIER("복사기", ProductMiddleCategory.OFFICE_SUPPLIES),
    DESK("책상", ProductMiddleCategory.OFFICE_SUPPLIES),
    OFFICE_CHAIR("의자", ProductMiddleCategory.OFFICE_SUPPLIES),
    // COMPUTER_SUPPLIES
    KEYBOARD("키보드", ProductMiddleCategory.COMPUTER_SUPPLIES),
    MOUSE("마우스", ProductMiddleCategory.COMPUTER_SUPPLIES),
    MONITOR("모니터", ProductMiddleCategory.COMPUTER_SUPPLIES),
    USB("USB", ProductMiddleCategory.COMPUTER_SUPPLIES),
    // EXERCISE_EQUIPMENT
    DUMBBELL("덤벨", ProductMiddleCategory.EXERCISE_EQUIPMENT),
    YOGA_MAT("요가매트", ProductMiddleCategory.EXERCISE_EQUIPMENT),
    TREADMILL("러닝머신", ProductMiddleCategory.EXERCISE_EQUIPMENT),
    BICYCLE("자전거", ProductMiddleCategory.EXERCISE_EQUIPMENT),
    // SPORTS_CLOTHING
    SPORTSWEAR_CLOTHING("운동복", ProductMiddleCategory.SPORTS_CLOTHING),
    SPORTS_SHOES("운동화", ProductMiddleCategory.SPORTS_CLOTHING),
    SPORTS_BRA("스포츠 브라", ProductMiddleCategory.SPORTS_CLOTHING),
    TRAINING_WEAR("트레이닝복", ProductMiddleCategory.SPORTS_CLOTHING),
    // OUTDOOR_ACTIVITIES
    TENT("텐트", ProductMiddleCategory.OUTDOOR_ACTIVITIES),
    BACKPACK("배낭", ProductMiddleCategory.OUTDOOR_ACTIVITIES),
    HIKING_BOOTS("등산화", ProductMiddleCategory.OUTDOOR_ACTIVITIES),
    CAMPING_SUPPLIES("캠핑용품", ProductMiddleCategory.OUTDOOR_ACTIVITIES),
    // TRAVEL_SUPPLIES
    TRAVEL_BAG("여행가방", ProductMiddleCategory.TRAVEL_SUPPLIES),
    PASSPORT_WALLET("여권지갑", ProductMiddleCategory.TRAVEL_SUPPLIES),
    TRAVEL_SET("여행용 세트", ProductMiddleCategory.TRAVEL_SUPPLIES),
    NECK_PILLOW("목베개", ProductMiddleCategory.TRAVEL_SUPPLIES),
    // PET_SUPPLIES
    PET_FOOD("애완동물 사료", ProductMiddleCategory.PET_SUPPLIES),
    PET_TOYS("장난감", ProductMiddleCategory.PET_SUPPLIES),
    PET_BED("침대", ProductMiddleCategory.PET_SUPPLIES),
    PET_LEASH("목줄", ProductMiddleCategory.PET_SUPPLIES),
    // HEALTH_SUPPLIES
    VITAMINS("비타민", ProductMiddleCategory.HEALTH_SUPPLIES),
    HEALTH_SUPPLEMENTS("건강보조식품", ProductMiddleCategory.HEALTH_SUPPLIES),
    MASSAGER("마사지기", ProductMiddleCategory.HEALTH_SUPPLIES),
    THERMOMETER("체온계", ProductMiddleCategory.HEALTH_SUPPLIES),
    // HOBBY_SUPPLIES
    MUSICAL_INSTRUMENTS("악기", ProductMiddleCategory.HOBBY_SUPPLIES),
    ART_SUPPLIES("미술용품", ProductMiddleCategory.HOBBY_SUPPLIES),
    DIY_KITS("DIY 키트", ProductMiddleCategory.HOBBY_SUPPLIES),
    PUZZLES("퍼즐", ProductMiddleCategory.HOBBY_SUPPLIES);
	
	 private final String displayName;
	 private final ProductMiddleCategory productMiddleCategory;
	 
	 public String getDisplayName() {
		 return displayName;
	 }
	 public ProductMiddleCategory getProductMiddleCategory() {
		 return productMiddleCategory;
	 }

}
