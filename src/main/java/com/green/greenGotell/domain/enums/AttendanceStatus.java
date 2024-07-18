package com.green.greenGotell.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AttendanceStatus {
	
	LATE(1,"지각"),
	EARLY_DEPARTURE(2,"조퇴"),
	NORMAL(3,"정상"),
	HOLIDAY(4,"휴일"),
	SICK_LEAVE(5,"병가"),
	VACATION(6,"휴가"),
	COMPASSIONATE_LEAVE(7,"경조사"),
	;
	
	private final int number;
	private final String KoName;


}
