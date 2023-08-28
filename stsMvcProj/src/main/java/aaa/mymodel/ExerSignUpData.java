package aaa.mymodel;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ExerSignUpData {

	@NotEmpty(message = "아이디가 없습니다!")
	/* @Size(min=4, max=20, message="아이디의 길이는 4~20자 가능합니다.") */
	@Pattern(regexp = "^[a-zA-Z0-9]{6,16}$",message="아이디는 영어,숫자 6~16자 가능합니다.")
	String id;
	
	@NotEmpty(message = "비번도 필수입니다!")
	@Size(min=6, max=20, message="비밀번호는 6~20자 가능합니다.")
	String pw1;
	String pw2;
	
	@NotEmpty(message = "이름이 없으시진 않겠죠?")
	@Pattern(regexp="[가-힣]{2,5}", message="한글만 2~5자 가능")
	String uname;
	
	@Size(min=2, max=8, message="닉네임은 2~8자 이내로!")
	String nickname;
	
	@NotEmpty(message = "성별은 필수로 골라주세요!")
	String[] gender= {"남","여"};
	String email;
	String emailDomain;
	
	
    @Min(value = 8, message = "나이는 8살 이상!")
    @Max(value = 130, message = "설마... 130살 이상?")
	int age;
	
	int sonnum;
	
	
}
