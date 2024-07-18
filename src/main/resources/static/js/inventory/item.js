const categories = {
            "의류": {
                "남성 의류": ["정장", "캐주얼", "스포츠웨어", "수영복"],
                "여성 의류": ["드레스", "캐주얼", "스포츠웨어", "수영복"],
                "아동 의류": ["정장", "캐주얼", "스포츠웨어", "수영복"]
            },
            "식품": {
                "신선 식품": ["과일", "채소", "육류", "해산물"],
                "가공 식품": ["스낵", "음료", "통조림", "냉동식품"],
                "조미료": ["소스", "향신료", "소금", "설탕"]
            },
            "주방용품": {
                "조리 도구": ["냄비", "프라이팬", "칼", "도마"],
                "식기": ["접시", "컵", "그릇", "수저"],
                "주방 가전": ["전자레인지", "믹서기", "커피머신", "토스터"]
            },
            "생활용품": {
                "청소 용품": ["청소기", "걸레", "세제", "쓰레기통"],
                "세탁 용품": ["세탁기", "세제", "섬유유연제", "빨래건조대"],
                "욕실 용품": ["샴푸", "비누", "수건", "욕실매트"]
            },
            "인테리어": {
                "가구": ["침대", "소파", "테이블", "의자"],
                "조명": ["스탠드", "천장등", "벽등", "LED 조명"],
                "장식품": ["그림", "화병", "시계", "쿠션"]
            },
            "가전 디지털": {
                "가전 제품": ["TV", "냉장고", "세탁기", "에어컨"],
                "디지털 기기": ["스마트폰", "태블릿", "노트북", "카메라"],
                "음향 기기": ["스피커", "헤드폰", "이어폰", "앰프"]
            },
            "문구/오피스": {
                "문구류": ["펜", "노트", "파일", "스티커"],
                "오피스 용품": ["프린터", "복사기", "책상", "의자"],
                "컴퓨터 용품": ["키보드", "마우스", "모니터", "USB"]
            },
            "스포츠": {
                "운동 기구": ["덤벨", "요가매트", "러닝머신", "자전거"],
                "스포츠 의류": ["운동복", "운동화", "스포츠 브라", "트레이닝복"],
                "야외 활동": ["텐트", "배낭", "등산화", "캠핑용품"]
            },
            "기타": {
                "여행 용품": ["여행가방", "여권지갑", "여행용 세트", "목베개"],
                "애완용품": ["애완동물 사료", "장난감", "침대", "목줄"],
                "건강 용품": ["비타민", "건강보조식품", "마사지기", "체온계"],
                "취미 용품": ["악기", "미술용품", "DIY 키트", "퍼즐"]
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
                    option.text = sub;
                    subCategory.appendChild(option);
                }
            }
        }
        function updateSubSubCategory() {
            const mainCategory = document.getElementById("main-category").value;
            const subCategory = document.getElementById("sub-category").value;
            const subSubCategory = document.getElementById("sub-sub-category");
            subSubCategory.innerHTML = '<option value="">선택하세요</option>';
            if (mainCategory && subCategory && categories[mainCategory][subCategory]) {
                for (const subSub of categories[mainCategory][subCategory]) {
                    const option = document.createElement("option");
                    option.value = subSub;
                    option.text = subSub;
                    subSubCategory.appendChild(option);
                }
            }
        }