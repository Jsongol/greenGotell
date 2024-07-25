package com.green.greenGotell.controller;


import com.green.greenGotell.domain.entity.Event;
import com.green.greenGotell.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/calendar")
@RequiredArgsConstructor
public class CalendarController {

    private final EventService eventService;

    @GetMapping
    public String showCalendar() {
        return "views/calendar/calendar"; // Thymeleaf 템플릿 파일명 (calendar.html)
    }

    @PostMapping("/add")
    public String addEvent(
            @RequestParam(name = "date") String date,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "description") String description,
            RedirectAttributes redirectAttributes
    ) {
        // 새로운 Event 객체를 생성하고 값을 설정합니다.
        Event event = new Event();
        event.setDate(date);
        event.setTitle(title);
        event.setDescription(description);

        // 이벤트를 데이터베이스에 저장합니다.
        eventService.saveEvent(event);

        // 성공 메시지를 설정하고 리디렉션
        redirectAttributes.addFlashAttribute("message", "일정이 성공적으로 추가되었습니다.");
        return "redirect:/calendar";
    }
}