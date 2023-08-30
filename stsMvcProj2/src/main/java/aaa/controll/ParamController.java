package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/request")
public class ParamController {

	@RequestMapping("param1")
	String param1(HttpServletRequest request) {
		//param 이 없을 경우 null 로 처리
		String str = "param1:"+request.getParameter("id");
		str+= "," +request.getParameter("age");
		str+= "," +request.getParameter("marriage");
		System.out.println(str);
		return "req/param";
	}
	
	@RequestMapping("param2")
	String param2(String id, int age, boolean marriage) {
		// param 이 없을 경우 에러 발생
		System.out.println("param2:"+id+ ","+ age+ "," +marriage);
		return "req/param";
	}
	
	@RequestMapping("param3")
	String param3(
			@RequestParam("id")String pid, 
			@RequestParam("aaa")int age, 
			@RequestParam("mrg")boolean marriage) {
		// param 이 없을 경우 에러 발생
		System.out.println("param3:"+pid+ ","+ age+ "," +marriage);
		return "req/param";
	}
	
	@RequestMapping("param4")
	String param4(
			@RequestParam(value = "id", defaultValue = "qwer")String pid, 
			@RequestParam(value = "aaa", required = false, defaultValue = "15")int age, 
			@RequestParam(value = "mrg", defaultValue = "false")boolean marriage) {
		// param 이 없을 경우 에러 발생
		System.out.println("param4:"+pid+ ","+ age+ "," +marriage);
		return "req/param";
	}
	/*
	 커피주문을 구현하세요
	 주문내용
	 커피종류 : 필수
	 잔수 : 선택 --> 없을 경우 1잔
	 
	 아메리카노 : 2200
	 아프리카노 : 2300
	 아시아노   : 2500
	 
	 결과
	 커피이름 , 잔수, 금액
	 * */
}
