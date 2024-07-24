package com.green.greenGotell.controller;



import com.green.greenGotell.domain.entity.Event;
import com.green.greenGotell.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event savedEvent = eventService.saveEvent(event);
        return ResponseEntity.ok(savedEvent);
    }

    @GetMapping
    public ResponseEntity<List<Event>> getEvents(@RequestParam int year, @RequestParam int month) {
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
        List<Event> events = eventService.findEventsByYearAndMonth(startDate, endDate);
        return ResponseEntity.ok(events);
    }
}
