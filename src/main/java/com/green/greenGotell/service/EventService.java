package com.green.greenGotell.service;


import com.green.greenGotell.domain.dto.EventDTO;
import com.green.greenGotell.domain.entity.Event;
import com.green.greenGotell.domain.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }
    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(Event::toEventDTO)
                .collect(Collectors.toList());
    }// 신규
}