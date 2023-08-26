package aaa.control;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import aaa.model.JoinData;
import aaa.model.MyJoinData;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/review")
public class MyValidController {

	@GetMapping("myvalidation")
	String myvalidForm(MyJoinData jd) {
		
		return "review/myValidForm";
	}
	
	@PostMapping("myvalidation")
	String myvalidReg(@Valid MyJoinData jd, BindingResult br) {
		
		System.out.println("validReg : "+br.hasErrors());
		if(br.hasErrors()) {//에러가 있으면
			return "review/myValidForm";
		}
		
		
		//에러가 없으면
		return "review/myValidReg";
	}
	
	
}
