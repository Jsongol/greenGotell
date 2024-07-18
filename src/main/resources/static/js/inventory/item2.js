const categories = {
	CLOTHING: {
		MENS_CLOTHING: {
			SUIT: "정장",
			CASUAL: "캐주얼",
			SPORTSWEAR: "스포츠웨어",
			SWIMWEAR: "수영복"
		},
		WOMENS_CLOTHING: {
			DRESS: "드레스",
			WOMENS_CASUAL: "캐주얼",
			WOMENS_SPORTSWEAR: "스포츠웨어",
			WOMENS_SWIMWEAR: "수영복"
		},
		KIDS_CLOTHING: {
			KIDS_SUIT: "정장",
			KIDS_CASUAL: "캐주얼",
			KIDS_SPORTSWEAR: "스포츠웨어",
			KIDS_SWIMWEAR: "수영복"
		}
	},
	FOOD: {
		FRESH_FOOD: {
			FRUIT: "과일",
			VEGETABLE: "채소",
			MEAT: "육류",
			SEAFOOD: "해산물"
		},
		PROCESSED_FOOD: {
			SNACK: "스낵",
			BEVERAGE: "음료",
			CANNED_FOOD: "통조림",
			FROZEN_FOOD: "냉동식품"
		},
		SEASONING: {
			SAUCE: "소스",
			SPICE: "향신료",
			SALT: "소금",
			SUGAR: "설탕"
		}
	},
	KITCHENWARE: {
		COOKING_TOOLS: {
			POT: "냄비",
			FRYING_PAN: "프라이팬",
			KNIFE: "칼",
			CUTTING_BOARD: "도마"
		},
		TABLEWARE: {
			PLATE: "접시",
			CUP: "컵",
			BOWL: "그릇",
			SPOON: "수저"
		},
		KITCHEN_APPLIANCES: {
			MICROWAVE: "전자레인지",
			BLENDER: "믹서기",
			COFFEE_MACHINE: "커피머신",
			TOASTER: "토스터"
		}
	},
	HOUSEHOLD: {
		CLEANING_SUPPLIES: {
			VACUUM_CLEANER: "청소기",
			MOP: "걸레",
			DETERGENT: "세제",
			TRASH_CAN: "쓰레기통"
		},
		LAUNDRY_SUPPLIES: {
			WASHING_MACHINE: "세탁기",
			LAUNDRY_DETERGENT: "세제",
			FABRIC_SOFTENER: "섬유유연제",
			DRYING_RACK: "빨래건조대"
		},
		BATHROOM_SUPPLIES: {
			SHAMPOO: "샴푸",
			SOAP: "비누",
			TOWEL: "수건",
			BATH_MAT:"욕실매트"
		}
	},
	INTERIOR: {
		FURNITURE:{
			BED: "침대",
			SOFA: "소파",
			TABLE: "테이블",
			CHAIR: "의자",
		},
		LIGHTING : {
			STAND: "스탠드",
			CEILING_LIGHT: "천장등",
			WALL_LIGHT: "벽등",
			LED_LIGHT: "LED 조명"
		},
		DECORATIONS: {
			PAINTING:"그림",
			VASE: "화병",
			CLOCK: "시계",
			CUSHION: "쿠션"
		}
	},
	ELECTRONICS: {
		HOME_APPLIANCES: {
			TV: "TV",
			REFRIGERATOR: "냉장고",
			WASHING_MACHINE_APPLIANCE: "세탁기",
			AIR_CONDITIONER: "에어컨"
		},
		DIGITAL_DEVICES: {
			SMARTPHONE: "스마트폰",
			TABLET: "태블릿",
			LAPTOP: "노트북",
			CAMERA: "카메라"
		},
		AUDIO_DEVICES: {
			SPEAKER: "스피커",
			HEADPHONES: "헤드폰",
			EARPHONES: "이어폰",
			AMPLIFIER: "앰프"
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
			const option = document.createElement("option");
			option.value = sub;
			option.text = categories[mainCategory][sub];
			subCategory.appendChild(option);
		}
	}
}

function updateSubSubCategory() {
	const mainCategory = document.getElementById("main-category").value;
	const subCategory = document.getElementById("sub-category").value;
	const subSubCategory = document.getElementById("sub-sub-category");
	subSubCategory.innerHTML = '<option value="">소분류</option>';

	if (mainCategory && subCategory && categories[mainCategory][subCategory]) {
		for (const subSub in categories[mainCategory][subCategory]) {
			const option = document.createElement("option");
			option.value = subSub;
			option.text = categories[mainCategory][subCategory][subSub];
			subSubCategory.appendChild(option);
		}
	}
}