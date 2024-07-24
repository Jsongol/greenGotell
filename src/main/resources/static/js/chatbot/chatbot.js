/**
 * 
 */
var client;
var key;
let flag = false;

// 브라우저가 WebSocket을 지원하는지 확인하는 함수
function isWebSocketSupported() {
	return 'WebSocket' in window;
}

// WebSocket 지원 여부를 출력
if (isWebSocketSupported()) {
	console.log("이 브라우저는 WebSocket을 지원합니다.");
} else {
	console.log("이 브라우저는 WebSocket을 지원하지 않습니다.");
}
function formatDate(now) {
	const year = now.getFullYear();
	const month = now.getMonth() + 1; //월정보는 0월부터 시작하기 때문에 +1 해줘야함
	const date = now.getDate();

	//일:0, 월:1, 화:2 ~ 토:6
	const dayOfWeek = now.getDay();
	const days = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];

	return `${year}년 ${month}월 ${date}일 ${days[dayOfWeek]}`;
}

//대화 내용 추가
function showMessage(tag) {
	$("#chat-content").append(tag)
	//스크롤을 제일 아래로
	$("#chat-content").scrollTop($("#chat-content").prop("scrollHeight"));
}

//웹소켓 연결 후 인사말 출력
function connect() {
	client = Stomp.over(new SockJS('/ws'));
	client.connect({}, (frame) => {
		key = new Date().getTime();
		//console.log(frame)
		//구독설정
		client.subscribe(`/topic/bot/${key}`, (answer) => {
			var msgObj = answer.body;
			//console.log("msg:", msgObj);
			//console.log("answer:", answer);
			var now = new Date();
			var date = formatDate(now);
			var tag = `<div class="flex center date">${date}</div>
						<div class="msg bot flex">
							<div class="icon">
								<img src="/images/chatbot.png">
							</div>
							<div class="message">
								<div class="part">
									<p>${msgObj}</p>
									</div>
							</div>
						</div>
						<div id="categories">
							<button class="btn" onclick="toggleCategoryMessage(this, '사람 찾기')">사람 찾기</button>
						    <button class="btn" onclick="toggleCategoryMessage(this, '스케줄 확인')">스케줄 확인</button>
						    <button class="btn" onclick="toggleCategoryMessage(this, '내 정보 변경')">내 정보 변경</button>
							<button class="btn" onclick="toggleCategoryMessage(this, '공지사항 확인')">공지사항 확인</button>
						 </div>`;

			showMessage(tag);
		});

		//* JSON(자바스크립트 객체 표현식) > 이걸 보면 controller 클래스에서 매핑이 됨
		var data = {
			key: key,
			content: "hello",
			name: "guest" //principle.getName 이름의 값으로 넣으면 될 듯..?
		}
		//접속하자마자 연결시도
		client.send("/bot/hello", {}, JSON.stringify(data));
		//*/
	})
}

//웹소켓 종료
function disconnect() {
	client.disconnect(() => {
		console.log("Disconnected...")
	});
}

//종료(X) 버튼 클릭 시 이벤트
function btnCloseClicked() {
	$("#bot-container").hide();
	//대화창 리셋
	$("#chat-content").html("");
	disconnect();
	flag = false;

}

// 챗봇 시작/종료 버튼 이벤트
function btnBotClicked() {
	if (flag) {
		// 챗봇 종료
		btnCloseClicked();
	} else {
		// 챗봇 시작
		$("#bot-container").show();
		connect();
		flag = true;
	}
}
function clearQuestion() {
	$("#question").val("")//setter처럼 사용 (""없이 그냥이면 getter)
}

//메시지 전송
//사용자가 채팅메시지를 입력했을때
function btnMsgSendClicked() {
	var question = $("#question").val().trim(); //jQeury는 메서드(.으로 접근해서 객체 안에 있는걸 쓰는 것) 기반
	if (question.length < 2) {
		alert("질문은 최소 2글자 이상으로 부탁드립니다.");
		//clearQuestion();
		return;
	}

	// 사용자 메시지 화면에 표시
	var now = new Date();
	var userMessageTag = `<div class="msg user flex">
                            <div class="message">
                                <div class="part">
                                    <p>${question}</p>
                                </div>
                            </div>
                          </div>`;
	showMessage(userMessageTag);

	var data = {
		key: key,
		content: question,
		name: "guest" //principle.getName 이름의 값으로 넣으면 될 듯..?
	}
	//접속하자마자 연결시도
	client.send("/bot/question", {}, JSON.stringify(data));
	clearQuestion()
}

// 카테고리 메시지 전송 (토글 기능 포함)
function toggleCategoryMessage(btn, content) {
	$("#categories .btn").removeClass('active'); // 모든 버튼의 active 상태 해제
	$(btn).addClass('active'); // 클릭한 버튼만 active 상태로 설정
	$("#categories .btn").prop('disabled', true); // 모든 버튼 비활성화
	$(btn).prop('disabled', false); // 클릭한 버튼만 활성화 유지
	var data = {
		key: key,
		content: content,
		name: "guest"
	};
	client.send("/bot/question", {}, JSON.stringify(data));
	showNextQuestion(content);
}


//다음 질문 보여주는 함수
function showNextQuestion(category) {
	let options = '';
	let message = '';
	let showRestartOption = false;
	
	switch (category) {
		case '사람 찾기':
			message = '이름을 입력해주세요';
			options = ''; // 추가 하위 질문이 없으므로 비워둠
			break;
		case '스케줄 확인':
			message = '찾으시는 스케줄을 눌러주세요';
			options = `	<div id="categories">
            			<button class="btn" onclick="toggleCategoryMessage(this, '남은 연차 확인')">남은 연차 확인</button>
            			<button class="btn" onclick="toggleCategoryMessage(this, '휴일 확인')">휴일 확인</button>
            			</div>
            			`;

			break;
		case '내 정보 변경':
			message = '우축 상단 마이페이지 클릭 > 우축 상단 프로필 수정 클릭 후 변경 하시면 됩니다.';
			options = ''; // 추가 하위 질문이 없으므로 비워둠
			break;
		case '공지사항 확인':
			message = '찾으시는 공지를 눌러주세요';
			options = `	<div id="categories">
            			<button class="btn" onclick="toggleCategoryMessage(this, '오늘 공지 확인')">남은 연차 확인</button>
            			<button class="btn" onclick="toggleCategoryMessage(this, '이전 공지 확인')">남은 연차 확인</button>
            			</div>
            `;
			break;
		case '이름 입력': // '사람 찾기' 단계에서 다음 질문
			message = '입력한 이름에 대해 찾고 있습니다. 잠시만 기다려 주세요.';
			options = ''; // 다음 단계가 없으므로 비워둠
			
			break;
		case '남은 연차 확인': // '스케줄 확인' 단계에서 다음 질문
			message = '남은 연차를 확인하고 있습니다. 잠시만 기다려 주세요.';
			options = ''; // 다음 단계가 없으므로 비워둠
			break;
		case '휴일 확인': // '스케줄 확인' 단계에서 다음 질문
			message = '휴일 정보를 확인하고 있습니다. 잠시만 기다려 주세요.';
			options = ''; // 다음 단계가 없으므로 비워둠
			break;
		case '오늘 공지 확인': // '공지사항 확인' 단계에서 다음 질문
			message = '오늘의 공지를 확인하고 있습니다. 잠시만 기다려 주세요.';
			options = ''; // 다음 단계가 없으므로 비워둠
			break;
		case '이전 공지 확인': // '공지사항 확인' 단계에서 다음 질문
			message = '이전 공지를 확인하고 있습니다. 잠시만 기다려 주세요.';
			options = ''; // 다음 단계가 없으므로 비워둠
			break;

		default:
			options='';
	}

	if (message) {
		var now = new Date();
		var tag = `<div class="msg bot flex">
                    <div class="icon">
                        <img src="/images/chatbot.png">
                    </div>
                    <div class="message">
                        <div class="part">
                            <p>${message}</p>
                        </div>
                    </div>
                   </div>`;
		showMessage(tag);
		}
 if (options) {
		var tag = `<div class="msg bot flex">
                    <div class="message">
                        ${options}
                    </div>
                  </div>`;
		showMessage(tag);
	}

}


// 카테고리 응답 처리 함수
function sendCategoryResponse(content) {
	var data = {
		key: key,
		content: content,
		name: "guest"
	};
	client.send("/bot/question", {}, JSON.stringify(data));
}


$(function() {
	$("#btn-bot").click(btnBotClicked);

	// 엔터 키로 메시지 전송 이벤트 추가
	$("#question").keypress(function(event) {
		if (event.which == 13) { // 13은 Enter 키의 키코드
			event.preventDefault(); // 기본 엔터 키 이벤트를 막음
			btnMsgSendClicked(); // 메시지 전송 함수 호출
		}
	});
});