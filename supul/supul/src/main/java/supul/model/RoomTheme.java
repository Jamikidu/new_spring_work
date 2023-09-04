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
	
	
	//LocalDate date = LocalDate.of(2023, Month.SEPTEMBER, 4); // 년, 월, 일 설정
	LocalDate date;	// 년, 월, 일
	LocalTime time1 = LocalTime.of(10, 0); // 시, 분 설정
	LocalTime time2 = LocalTime.of(11, 10);
	LocalTime time3 = LocalTime.of(12, 20);
	LocalTime time4 = LocalTime.of(13, 30);
	LocalTime time5 = LocalTime.of(14, 40); 
	LocalTime time6 = LocalTime.of(15, 50);
	LocalTime time7 = LocalTime.of(17, 0);
	LocalTime time8 = LocalTime.of(18, 10);
	LocalTime time9 = LocalTime.of(19, 20);
	LocalTime time10 = LocalTime.of(20, 30);
	LocalTime time11 = LocalTime.of(21, 40);
	
	LocalTime[] timeslot = {
			time1,time2,time3,time4,time5,time6,time7,time8,time9,time10
	};
	
	List<LocalDateTime> compdatetimes = new ArrayList<>();
	
	public void addTime() {
		compdatetimes.add(LocalDateTime.of(date, time1));
		compdatetimes.add(LocalDateTime.of(date, time2));
		compdatetimes.add(LocalDateTime.of(date, time3));
		compdatetimes.add(LocalDateTime.of(date, time4));
		compdatetimes.add(LocalDateTime.of(date, time5));
		compdatetimes.add(LocalDateTime.of(date, time6));
		compdatetimes.add(LocalDateTime.of(date, time7));
		compdatetimes.add(LocalDateTime.of(date, time8));
		compdatetimes.add(LocalDateTime.of(date, time9));
		compdatetimes.add(LocalDateTime.of(date, time10));
		compdatetimes.add(LocalDateTime.of(date, time11));
//				LocalDateTime.of(date, time1),
//				LocalDateTime.of(date, time2),
//				LocalDateTime.of(date, time3),
//				LocalDateTime.of(date, time4),
//				LocalDateTime.of(date, time5),
//				LocalDateTime.of(date, time6),
//				LocalDateTime.of(date, time7),
//				LocalDateTime.of(date, time8),
//				LocalDateTime.of(date, time9),
//				LocalDateTime.of(date, time10),
//				LocalDateTime.of(date, time11)
	}
	


	
    public boolean availabletime(LocalDateTime cdt) {
        LocalDateTime nowtime = LocalDateTime.now();
        // 현재 시간과 예약 시간 사이의 차이(분 단위)를 계산합니다.
        long remaintime = ChronoUnit.MINUTES.between(nowtime, cdt);

        // 예약 가능한지 확인합니다 (예: 현재 시간으로부터 30분 이상 남은 경우)
        return remaintime >= 30;
    }
	
    
    
}
