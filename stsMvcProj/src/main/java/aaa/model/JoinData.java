package aaa.model;


import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class JoinData {
	
	@NotEmpty(message = "아이디가 없오")
	@Size(min=3, max = 10, message="크기는 3~10 사이!") //message 지정안해줘도 나오긴함
	String pid;
	
//	@Size(min=1, max = 4, message="이름 길이좀!!!")
	@Pattern(regexp="[가-힣]{2,10}", message="한글만 2~10자 가능")
	String pname;
	
	String pw1;
	String pw2;
	
	@Email(message="이메일 형식") // 정확도가 너무 떨어져서 그냥 패턴 따로 넣어주는게 좋다
	String email;
	
	//@Past(message = "오늘 이전만 입력")
	//Date birth;
	

	String birth;
	
	@Positive(message="반은 양수만..")
	int ban;
}
