package supul.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("rvDTO")
@Data
public class Reservation {
	 
	
	String rv_id;
	LocalDate date;
	LocalTime time;
	int rv_people;
	int rv_price;
	String userName="일영준";
	String themeName;

	LocalDateTime rv_date;	//예약을 한 시간 시,분,초까지
	

}
