package aaa.controll.mycon;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.model.MyJoinData;
import aaa.mymodel.ExerSignUpData;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/mysignup")
public class ExerSignUpController {

	@GetMapping("signup")
	String exerLoginForm(ExerSignUpData sd) {
		
		return "exer_login/exerLoginForm";
	}
	
	@PostMapping("signup")
	String myvalidReg(@Valid ExerSignUpData sud, BindingResult br) { // BindingResult는 검증 오류가 발생할 경우 오류 내용을 보관하는 스프링 프레임워크에서 제공하는 객체
		
		System.out.println("validReg : "+br.hasErrors());
		if(br.hasErrors()) {//에러가 있으면
			return "exer_login/exerLoginForm";	//다시 로그인 화면으로 돌아감
		}
		if(!sud.getPw1().equals(sud.getPw2())) { //pw1과 pw2가 일치하지 않으면
			br.rejectValue("pw2", null, "암호 불일치!");
			return "exer_login/exerLoginForm";
		}
		if(!(sud.getSonnum()==7)) { //sonnum이 7이 아니라면
			br.rejectValue("sonnum", null, "우리흥의 등번호를 모른다면.. 저희는 함께 할 수 없습니다.");
			return "exer_login/exerLoginForm";
		}
		
		//에러가 없다면!
		return "exer_login/exerLoginReg";
	}
	
}
