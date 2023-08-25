package aaa.model;


import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MyJoinData {
	
	@NotEmpty(message = "아이디가 어디감?")
	@Pattern(regexp="[가-힣]{2,5}",message="한글만 2~5자")
	String pname;
	
	@Positive(message="성적은 0이상 양수만..")
	@Min(value=0,message="0이상 이어야지")
	@Max(value=100,message="100이하 이어야지")
	int jum1;
	
	@Positive(message="성적은 0이상 양수만..")
	@Min(value=0,message="0이상 이어야지")
	@Max(value=100,message="100이하 이어야지")
	int jum2;
	
	@Positive(message="성적은 0이상 양수만..")
	@Min(value=0,message="0이상 이어야지")
	@Max(value=100,message="100이하 이어야지")
	int jum3;
}
