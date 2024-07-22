const categories = {
	CLOTHING: {
		MENS_CLOTHING: {
			Name: "남성의류",
			SUIT: "정장",
			CASUAL: "캐주얼",
			SPORTSWEAR: "스포츠웨어",
			SWIMWEAR: "수영복"
		},
		WOMENS_CLOTHING: {
			Name: "여성의류",
			DRESS: "드레스",
			WOMENS_CASUAL: "캐주얼",
			WOMENS_SPORTSWEAR: "스포츠웨어",
			WOMENS_SWIMWEAR: "수영복"
		},
		KIDS_CLOTHING: {
			Name: "아동의류",
			KIDS_SUIT: "정장",
			KIDS_CASUAL: "캐주얼",
			KIDS_SPORTSWEAR: "스포츠웨어",
			KIDS_SWIMWEAR: "수영복"
		}
	},
	FOOD: {
		FRESH_FOOD: {
			Name: "신선식품",
			FRUIT: "과일",
			VEGETABLE: "채소",
			MEAT: "육류",
			SEAFOOD: "해산물"
		},
		PROCESSED_FOOD: {
			Name: "가공식품",
			SNACK: "스낵",
			BEVERAGE: "음료",
			CANNED_FOOD: "통조림",
			FROZEN_FOOD: "냉동식품"
		},
		SEASONING: {
			Name: "조미료",
			SAUCE: "소스",
			SPICE: "향신료",
			SALT: "소금",
			SUGAR: "설탕"
		}
	},
	KITCHENWARE: {
		COOKING_TOOLS: {
			Name: "조리도구",
			POT: "냄비",
			FRYING_PAN: "프라이팬",
			KNIFE: "칼",
			CUTTING_BOARD: "도마"
		},
		TABLEWARE: {
			Name: "식기",
			PLATE: "접시",
			CUP: "컵",
			BOWL: "그릇",
			SPOON: "수저"
		},
		KITCHEN_APPLIANCES: {
			Name: "주방가전",
			MICROWAVE: "전자레인지",
			BLENDER: "믹서기",
			COFFEE_MACHINE: "커피머신",
			TOASTER: "토스터"
		}
	},
	HOUSEHOLD: {
		CLEANING_SUPPLIES: {
			Name: "청소용품",
			VACUUM_CLEANER: "청소기",
			MOP: "걸레",
			DETERGENT: "세제",
			TRASH_CAN: "쓰레기통"
		},
		LAUNDRY_SUPPLIES: {
			Name: "섹탁용품",
			WASHING_MACHINE: "세탁기",
			LAUNDRY_DETERGENT: "세제",
			FABRIC_SOFTENER: "섬유유연제",
			DRYING_RACK: "빨래건조대"
		},
		BATHROOM_SUPPLIES: {
			Name: "욕실용품",
			SHAMPOO: "샴푸",
			SOAP: "비누",
			TOWEL: "수건",
			BATH_MAT: "욕실매트"
		}
	},
	INTERIOR: {
		FURNITURE: {
			Name: "가구",
			BED: "침대",
			SOFA: "소파",
			TABLE: "테이블",
			CHAIR: "의자",
		},
		LIGHTING: {
			Name: "조명",
			STAND: "스탠드",
			CEILING_LIGHT: "천장등",
			WALL_LIGHT: "벽등",
			LED_LIGHT: "LED 조명"
		},
		DECORATIONS: {
			Name: "장식품",
			PAINTING: "그림",
			VASE: "화병",
			CLOCK: "시계",
			CUSHION: "쿠션"
		}
	},
	ELECTRONICS: {
		HOME_APPLIANCES: {
			Name: "가전제품",
			TV: "TV",
			REFRIGERATOR: "냉장고",
			WASHING_MACHINE_APPLIANCE: "세탁기",
			AIR_CONDITIONER: "에어컨"
		},
		DIGITAL_DEVICES: {
			Name: "디지털기기",
			SMARTPHONE: "스마트폰",
			TABLET: "태블릿",
			LAPTOP: "노트북",
			CAMERA: "카메라"
		},
		AUDIO_DEVICES: {
			Name: "음향 기기",
			SPEAKER: "스피커",
			HEADPHONES: "헤드폰",
			EARPHONES: "이어폰",
			AMPLIFIER: "앰프"
		}
	},
	STATIONERY_OFFICE: {
		
		STATIONERY: {
			Name: "문구류",
			PEN: "펜",
			NOTEBOOK: "노트",
			FILE: "파일",
			STICKER: "스티커"
		},
		OFFICE_SUPPLIES: {
			Name: "오피스용품",
			PRINTER: "프린터",
			COPIER: "복사기",
			DESK: "책상",
			OFFICE_CHAIR: "의자"
		},
		COMPUTER_SUPPLIES: {
			Name: "컴퓨터용품",
			KEYBOARD: "키보드",
			MOUSE: "마우스",
			MONITOR: "모니터",
			USB: "USB"
		}

	},
	SPORTS: {

		EXERCISE_EQUIPMENT: {
			Name: "운동기구",
			DUMBBELL: "덤벨",
			YOGA_MAT: "요가매트",
			TREADMILL: "러닝머신",
			BICYCLE: "자전거"
		},
		SPORTS_CLOTHING: {
			Name: "스포츠의류",
			SPORTSWEAR_CLOTHING: "운동복",
			SPORTS_SHOES: "운동화",
			SPORTS_BRA: "스포츠 브라",
			TRAINING_WEAR: "트레이닝복"
		},
		OUTDOOR_ACTIVITIES: {
			Name: "야외활동",
			TENT: "텐트",
			BACKPACK: "배낭",
			HIKING_BOOTS: "등산화",
			CAMPING_SUPPLIES: "캠핑용품"
		}
	},

	OTHERS: {

		TRAVEL_SUPPLIES: {
			Name: "여행용품",
			TRAVEL_BAG: "여행가방",
			PASSPORT_WALLET: "여권지갑",
			TRAVEL_SET: "여행용 세트",
			NECK_PILLOW: "목배개"
		},
		PET_SUPPLIES: {
			Name: "애완용품",
			PET_FOOD: "애완동물 사료",
			PET_TOYS: "장난감",
			PET_BED: "침대",
			PET_LEASH: "목줄"
		},
		HEALTH_SUPPLIES: {
			Name: "건강용품",
			VITAMINS: "비타민",
			HEALTH_SUPPLEMENTS: "건강보조식품",
			MASSAGER: "마사지기",
			THERMOMETER: "체온계"
		},
		HOBBY_SUPPLIES: {
			Name: "취미용품",
			MUSICAL_INSTRUMENTS: "아기",
			ART_SUPPLIES: "미술용품",
			DIY_KITS: "DIY 키트",
			PUZZLES: "퍼즐"
		}
	}
};
function updateSubCategory() {
	const mainCategory = document.getElementById("main-category").value;
	const subCategory = document.getElementById("sub-category");
	const subSubCategory = document.getElementById("sub-sub-category");
	subCategory.innerHTML = '<option value="">중분류</option>';
	subSubCategory.innerHTML = '<option value="">소분류</option>';

	if (mainCategory && categories[mainCategory]) {
		for (const sub in categories[mainCategory]) {
			if (sub !== 'Name') { // 'Name' 속성은 건너뜀
				const option = document.createElement("option");
				option.value = categories[mainCategory][sub].Name; // 값에 한국어 이름 설정
				option.text = categories[mainCategory][sub].Name;
				subCategory.appendChild(option);
			}
		}
	}
}

function updateSubSubCategory() {
	const mainCategory = document.getElementById("main-category").value;
	const subCategory = document.getElementById("sub-category").value;
	const subSubCategory = document.getElementById("sub-sub-category");
	subSubCategory.innerHTML = '<option value="">소분류</option>';

	if (mainCategory && subCategory) {
		const subCategoryKey = Object.keys(categories[mainCategory]).find(key => categories[mainCategory][key].Name === subCategory);
		if (subCategoryKey && categories[mainCategory][subCategoryKey]) {
			for (const subSub in categories[mainCategory][subCategoryKey]) {
				if (subSub !== 'Name') { // 'Name' 속성은 건너뜀
					const option = document.createElement("option");
					option.value = categories[mainCategory][subCategoryKey][subSub]; // 값에 한국어 이름 설정
					option.text = categories[mainCategory][subCategoryKey][subSub];
					subSubCategory.appendChild(option);
				}
			}
		}
	}
}