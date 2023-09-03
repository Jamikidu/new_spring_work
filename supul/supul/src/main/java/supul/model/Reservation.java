package supul.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("rvDTO")
@Data
public class Reservation {
	 
	RoomTheme rt;
	
	String rvnum;
	String spot;
	String type;
	String title;
	String playtime;
	int users=4;			//원래는 form에서 받아와야함
	String id="ujin123";	//원래는 session정보에서 받아와야함
	String phone="010-1234-1234";	//이것도 session정보에서 받아와야함
	String pname="이유진";	//얘도
	LocalDate rvdate;
	LocalTime rvtime;
	
//	시간: 
//	테마명:
//	예약자
//	예약자번호
//	인원

}
