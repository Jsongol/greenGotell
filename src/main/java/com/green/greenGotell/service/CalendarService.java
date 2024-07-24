package com.green.greenGotell.service;

import com.green.greenGotell.domain.entity.Event;
import com.green.greenGotell.domain.repository.EventRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CalendarService {

    @Autowired
    private EventRepository eventRepository;

    public void addEvent(LocalDate date, String description) {
        Event event = new Event();
        event.setDate(date);
        event.setDescription(description);
        eventRepository.save(event);
    }
}
