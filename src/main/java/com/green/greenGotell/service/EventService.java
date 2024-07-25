package com.green.greenGotell.service;


import com.green.greenGotell.domain.entity.Event;
import com.green.greenGotell.domain.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }
}