package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping("/")
	//@ResponseBody
	String homeGo() {
		System.out.println("홈이다");
		//return "homehome";
		return "home";  // views/home.html
	}	
/*
application.yaml 설정

spring :
  thymeleaf:
    prefix : views/
    suffix : .html
    cache : false
     
 * */		
		
	@RequestMapping("/admin/{ser}")
	@ResponseBody
	String adminGo(@PathVariable String ser) {
		System.out.println("admin이다");
		
		return "admin : "+ ser + " 페이지";
	}	
}
