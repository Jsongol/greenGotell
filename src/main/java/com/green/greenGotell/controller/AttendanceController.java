package com.green.greenGotell.controller;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class AttendanceController {
	
	@GetMapping("/personnel/attendance")
	public String attendanceIist() {
		return "/views/personnel/attendance/attendanceRecord";
	}
	
	
	@GetMapping("/personnel/attendance/leave-request")
	public String gleaveRequestIist() {
		return "/views/personnel/attendance/leaveRequest";
	}
	

}
