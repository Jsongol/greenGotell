package com.green.greenGotell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalenderController {

    @GetMapping("/calender")
    public String showCalenderPage() {
        return "calender"; // `calender.html` 파일을 반환
    }
}