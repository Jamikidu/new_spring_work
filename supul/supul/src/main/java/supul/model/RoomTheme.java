package supul.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;


@Alias("themeDTO")
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
	
	LocalDate date = LocalDate.of(2023, Month.SEPTEMBER, 3); // 년, 월, 일 설정
	LocalTime time1 = LocalTime.of(10, 0); // 시, 분 설정
	LocalTime time2 = LocalTime.of(11, 10); // 시, 분 설정
	LocalTime time3 = LocalTime.of(12, 20); // 시, 분 설정
	LocalTime time4 = LocalTime.of(13, 30); // 시, 분 설정
	LocalTime time5 = LocalTime.of(14, 40); // 시, 분 설정
	LocalTime time6 = LocalTime.of(15, 50); // 시, 분 설정
	LocalTime time7 = LocalTime.of(17, 0); // 시, 분 설정
	LocalTime time8 = LocalTime.of(18, 10); // 시, 분 설정
	LocalTime time9 = LocalTime.of(19, 20); // 시, 분 설정
	LocalTime time10 = LocalTime.of(20, 30); // 시, 분 설정
	LocalTime time11 = LocalTime.of(21, 40); // 시, 분 설정
	LocalTime time12 = LocalTime.of(22, 50); // 시, 분 설정

	LocalDateTime[] timeslot = {
			LocalDateTime.of(date, time1),
			LocalDateTime.of(date, time2),
			LocalDateTime.of(date, time3),
			LocalDateTime.of(date, time4),
			LocalDateTime.of(date, time5),
			LocalDateTime.of(date, time6),
			LocalDateTime.of(date, time7),
			LocalDateTime.of(date, time8),
			LocalDateTime.of(date, time9),
			LocalDateTime.of(date, time10),
			LocalDateTime.of(date, time11),
			LocalDateTime.of(date, time12)
	};
	
	public boolean availabletime(LocalDateTime ts) {
        LocalDateTime 현재시간 = LocalDateTime.now();
        // 현재 시간과 예약 시간 사이의 차이(분 단위)를 계산합니다.
        long 예약까지분 = ChronoUnit.MINUTES.between(현재시간, ts);
        
        // 예약 가능한지 확인합니다 (예: 현재 시간으로부터 30분 이상 남은 경우)
        return 예약까지분 >= 30;
    }
	
    
    
}
