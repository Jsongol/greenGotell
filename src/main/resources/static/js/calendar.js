// calendar.js
document.addEventListener('DOMContentLoaded', function () {
    const calendarBody = document.getElementById('calendar-body');
    const calendarMonthYear = document.getElementById('calendar-month-year');
    const prevMonthBtn = document.getElementById('prev-month');
    const nextMonthBtn = document.getElementById('next-month');
    const scheduleForm = document.getElementById('schedule-form');
    const eventForm = document.getElementById('event-form');
    const selectedDateInput = document.getElementById('selected-date');
    const eventDescriptionInput = document.getElementById('event-description');
    const cancelEventBtn = document.getElementById('cancel-event');

    let currentDate = new Date();

    function renderCalendar() {
        const year = currentDate.getFullYear();
        const month = currentDate.getMonth();
        const firstDay = new Date(year, month, 1);
        const lastDay = new Date(year, month + 1, 0);
        const daysInMonth = lastDay.getDate();
        const startDay = firstDay.getDay();
        const today = new Date();

        calendarMonthYear.textContent = `${year}년 ${month + 1}월`;

        calendarBody.innerHTML = '';

        // Blank days before the first day of the month
        for (let i = 0; i < startDay; i++) {
            const blankDay = document.createElement('div');
            calendarBody.appendChild(blankDay);
        }

        // Days of the month
        for (let day = 1; day <= daysInMonth; day++) {
            const dayElement = document.createElement('div');
            dayElement.textContent = day;
            dayElement.addEventListener('click', () => {
                selectedDateInput.value = `${year}-${month + 1}-${day}`;
                scheduleForm.style.display = 'block';
            });

            if (today.getFullYear() === year && today.getMonth() === month && today.getDate() === day) {
                dayElement.classList.add('today');
            }

            calendarBody.appendChild(dayElement);
        }
    }

    prevMonthBtn.addEventListener('click', () => {
        currentDate.setMonth(currentDate.getMonth() - 1);
        renderCalendar();
    });

    nextMonthBtn.addEventListener('click', () => {
        currentDate.setMonth(currentDate.getMonth() + 1);
        renderCalendar();
    });

    eventForm.addEventListener('submit', (e) => {
        e.preventDefault();
        const eventDescription = eventDescriptionInput.value;
        const eventDate = selectedDateInput.value;
        // Handle event saving logic here

        alert(`Event added on ${eventDate}: ${eventDescription}`);
        scheduleForm.style.display = 'none';
        eventForm.reset();
    });

    cancelEventBtn.addEventListener('click', () => {
        scheduleForm.style.display = 'none';
    });

    renderCalendar();
});
