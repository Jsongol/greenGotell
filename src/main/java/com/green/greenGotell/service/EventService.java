package com.green.greenGotell.service;

import com.green.greenGotell.domain.entity.Event;
import com.green.greenGotell.domain.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> findEventsByYearAndMonth(int year, int month) {
        // 입력된 연도와 월로 LocalDate 객체 생성
        LocalDate startDate = LocalDate.of(year, month, 1);
        // 해당 월의 마지막 날 계산
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

        // Repository 메서드를 호출하여 결과를 반환
        return eventRepository.findByDateBetween(startDate, endDate);
    }
}
