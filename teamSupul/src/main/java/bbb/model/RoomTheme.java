package bbb.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;


@Data
public class RoomTheme {

	String spot="홍대점";
	String type="공포";
	String title = "윤기은바보";
	String content = "공포의 윤기은 공포의 윤기은 공포의 윤기은 공포의 윤기은 공포의 윤기은 공포의 윤기은 공포의 윤기은 공포의 윤기은 공포의 윤기은 공포의 윤기은 공포의 윤기은 공포의 윤기은 공포의 윤기은...";
	String people = "1 ~ 4 명";
	String playtime = "60분";
	String level = "5";
	String activity = "2";
	
	LocalDate date = LocalDate.of(2023, Month.SEPTEMBER, 1); // 년, 월, 일 설정
	LocalTime time1 = LocalTime.of(10, 0); // 시, 분 설정
	LocalTime time2 = LocalTime.of(11, 10); // 시, 분 설정
	LocalTime time3 = LocalTime.of(12, 20); // 시, 분 설정
	LocalTime time4 = LocalTime.of(13, 30); // 시, 분 설정
	LocalTime time5 = LocalTime.of(14, 40); // 시, 분 설정
	LocalTime time6 = LocalTime.of(15, 50); // 시, 분 설정
	LocalTime time7 = LocalTime.of(17, 0); // 시, 분 설정
	LocalTime time8 = LocalTime.of(18, 10); // 시, 분 설정

	LocalDateTime[] timeslot = {
			LocalDateTime.of(date, time1),
			LocalDateTime.of(date, time2),
			LocalDateTime.of(date, time3),
			LocalDateTime.of(date, time4),
			LocalDateTime.of(date, time5),
			LocalDateTime.of(date, time6),
			LocalDateTime.of(date, time7),
			LocalDateTime.of(date, time8),			
	};
	
    
    
}
