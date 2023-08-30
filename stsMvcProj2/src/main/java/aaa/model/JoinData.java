package aaa.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class JoinData {

	@NotEmpty(message = "아이디가 없오")
	@Size(min=3, max = 10, message = "id 길이 좀")
	String pid;
	
	@Pattern(regexp="[가-힣]{2,10}", message = "한글 2~10 입니다.")
	String pname;
	
	@NotEmpty(message = "비밀번호가 없오")
	String pw1;
	
	String pw2;
	
	@Email(message = "이메일 형식")
	String email;
	
	//@Past(message = "오늘 이전만 입력")
	//Date birth;
	
	String birth;
	
	@Positive(message = "양수만 입력")
	int ban;
}
