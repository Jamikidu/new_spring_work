package supul.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;


@Alias("themeDTO")
@Data
public class RoomTheme {

	String spot="홍대점";
	String type="공포";
	String title = "윤기은바보";
	String content = "공포의 윤기은 공포의 윤기은 공포의 윤기은...";
	int people = 4;
	int rv_price = 30000;
	String playtime = "60분";
	String level = "5";
	String activity = "2";

	
	LocalDate date;	// 년, 월, 일
	LocalTime time1; // 시, 분 설정
	LocalTime time2;
	LocalTime time3;
	LocalTime time4;
	LocalTime time5;
	LocalTime time6;
	LocalTime time7;
	LocalTime time8;
	LocalTime time9;
	LocalTime time10;
	LocalTime time11;

	
	LocalTime[] timeslot = {	// 시간들의 집합
			//time1,time2,time3,time4,time5,time6,time7,time8,time9,time10
			time1 = LocalTime.of(10, 0), // 시, 분 설정
			time2 = LocalTime.of(11, 10),
			time3 = LocalTime.of(12, 20),
			time4 = LocalTime.of(13, 30),
			time5 = LocalTime.of(14, 40),
			time6 = LocalTime.of(15, 50),
			time7 = LocalTime.of(17, 0),
			time8 = LocalTime.of(18, 10),
			time9 = LocalTime.of(19, 20),
			time10 = LocalTime.of(20, 30),
			time11 = LocalTime.of(21, 40)
	};
	
	
    public boolean availabletime(LocalTime lt) {	// 예약시간과 현재시간과 차이 계산식
    	
        LocalDateTime nowtime = LocalDateTime.now();
        
        if(nowtime.toLocalDate().equals(date)) {// 달력이 현재날짜일때만 계산
        	// 현재 시간과 예약 시간 사이의 차이(분 단위)를 계산합니다.
            long remaintime = ChronoUnit.MINUTES.between(nowtime.toLocalTime(), lt);

            // 예약 가능한지 확인합니다 (예: 현재 시간으로부터 30분 이상 남은 경우)
            return remaintime >= 30;
        }else {
        	return true;
        }
    }

}
