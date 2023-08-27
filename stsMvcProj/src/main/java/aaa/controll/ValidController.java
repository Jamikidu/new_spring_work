package aaa.controll;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import aaa.model.JoinData;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/form")
public class ValidController {

	
	@GetMapping("validation")
	String validForm(JoinData jd) {
		
		return "form/validForm";
	}
	
	@PostMapping("validation")
	String validReg(@Valid JoinData jd, BindingResult br) {
		
		System.out.println("validReg : "+br.hasErrors());
		
		if(br.hasErrors()) {//에러가 있으면
			return "form/validForm";
		}
		
		if(!jd.getPw1().equals(jd.getPw2())) { //암호가 일치하지 않으면
			br.rejectValue("pw2", null, "암호확인이 안됨!");
			return "form/validForm";
		}
		String[] str = {"aaa","bbb","ccc","ddd","eee"};
		
		//방법1
		if(Arrays.toString(str).contains(jd.getPid())){
			System.out.println("중복인뎁쇼?");
			br.rejectValue("pid", null, "이미 있는 id 입니다!");
			return "form/validForm";
		}
		
		//방법2 
//		for(String s : str) {
//			if(jd.getPid().equals(s)) {
//				br.rejectValue("pid", null, "이미 있는 id 입니다!");
//				return "form/validForm";
//			}
//		}
			
		
		//에러가 없으면
		return "form/validReg";
	}
	
	
}
