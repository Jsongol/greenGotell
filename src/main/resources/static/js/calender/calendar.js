document.addEventListener("DOMContentLoaded", function() {
    const calendarBody = document.getElementById("calendar-body");
    const monthYear = document.getElementById("calendar-month-year");
    const prevMonth = document.getElementById("prev-month");
    const nextMonth = document.getElementById("next-month");
    const scheduleForm = document.getElementById("schedule-form");
    const eventForm = document.getElementById("event-form");
    const selectedDateInput = document.getElementById("selected-date");
    const eventDescription = document.getElementById("event-description");

    let currentMonth = new Date().getMonth();
    let currentYear = new Date().getFullYear();

    const colors = ['red', 'blue', 'green', 'yellow', 'purple'];

    // 캘린더를 보여주는 함수
    function showCalendar(month, year) {
        calendarBody.innerHTML = "";
        const firstDay = (new Date(year, month)).getDay();
        const daysInMonth = new Date(year, month + 1, 0).getDate();
        monthYear.textContent = `${year}년 ${month + 1}월`;

        let date = 1;
        for (let i = 0; i < 6; i++) {
            for (let j = 0; j < 7; j++) {
                if (i === 0 && j < firstDay) {
                    calendarBody.innerHTML += '<div></div>';
                } else if (date > daysInMonth) {
                    break;
                } else {
                    const dayDiv = document.createElement('div');
                    dayDiv.classList.add('day');
                    dayDiv.textContent = date;
                    dayDiv.addEventListener('click', () => {
                        selectedDateInput.value = `${year}-${String(month + 1).padStart(2, '0')}-${String(date).padStart(2, '0')}`;
                        scheduleForm.style.display = 'block';
                    });
                    calendarBody.appendChild(dayDiv);
                    date++;
                }
            }
        }
        loadEvents(year, month); // 월 변경 시 이벤트 로드
    }

    // 이벤트를 서버에 저장하는 함수
    eventForm.addEventListener('submit', function(event) {
        event.preventDefault();
        const date = selectedDateInput.value;
        const description = eventDescription.value;

        if (!description) {
            alert("일정 설명을 입력해 주세요.");
            return;
        }

        fetch('/api/events', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                date: date,
                description: description
            })
        })
            .then(response => {
                if (response.ok) {
                    alert("할일이 추가되었습니다.");
                    scheduleForm.style.display = 'none';
                    eventDescription.value = '';
                    showCalendar(currentMonth, currentYear); // 이벤트 추가 후 캘린더 갱신
                } else {
                    alert("서버 오류가 발생했습니다.");
                }
            })
            .catch(error => {
                console.error('오류 발생:', error);
                alert('네트워크 오류가 발생했습니다.');
            });
    });

    // 취소 버튼 클릭 시
    document.getElementById('cancel-event').addEventListener('click', function() {
        scheduleForm.style.display = 'none';
        eventDescription.value = '';
    });

    // 이전 달 버튼 클릭 시
    prevMonth.addEventListener('click', function() {
        if (currentMonth === 0) {
            currentMonth = 11;
            currentYear--;
        } else {
            currentMonth--;
        }
        showCalendar(currentMonth, currentYear);
    });

    // 다음 달 버튼 클릭 시
    nextMonth.addEventListener('click', function() {
        if (currentMonth === 11) {
            currentMonth = 0;
            currentYear++;
        } else {
            currentMonth++;
        }
        showCalendar(currentMonth, currentYear);
    });

    // 서버에서 이벤트를 불러오는 함수
    function loadEvents(year, month) {
        fetch(`/api/events?year=${year}&month=${month + 1}`)
            .then(response => response.json())
            .then(events => {
                const dayDivs = calendarBody.getElementsByClassName('day');
                for (const dayDiv of dayDivs) {
                    const dayDate = `${year}-${String(month + 1).padStart(2, '0')}-${String(dayDiv.textContent).padStart(2, '0')}`;
                    const dayEvents = events.filter(event => event.date === dayDate);
                    for (const event of dayEvents) {
                        const eventDiv = document.createElement('div');
                        eventDiv.classList.add('event');
                        eventDiv.classList.add(colors[Math.floor(Math.random() * colors.length)]);
                        eventDiv.textContent = event.description;
                        dayDiv.appendChild(eventDiv);
                    }
                }
            })
            .catch(error => {
                console.error('이벤트 로드 오류:', error);
            });
    }

    showCalendar(currentMonth, currentYear);
});
