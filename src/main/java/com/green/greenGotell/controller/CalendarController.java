package com.green.greenGotell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.green.greenGotell.service.CalendarService;

@Controller
@RequestMapping("/calendar")
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

    @GetMapping
    public String showCalendarPage() {
        return "/views/calendar/calendar"; // `calendar.html` 파일을 반환
    }

    @PostMapping("/addEvent")
    public String addEvent(@RequestParam String date, @RequestParam String description, RedirectAttributes redirectAttributes) {
        calendarService.addEvent(date, description);
        redirectAttributes.addFlashAttribute("message", "할일이 추가되었습니다.");
        return "redirect:/calendar";
    }
}