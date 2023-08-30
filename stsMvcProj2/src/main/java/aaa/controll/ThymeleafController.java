package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {

	@RequestMapping("calc")
	String calc() {
		return "thyme/calc";
	}
	
	@RequestMapping("control")
	String control(Model mm) {
		
		String str1 = "아기상어";
		String str2 = "아기상어";
		String str3 = new String("아기상어");
		System.out.println("아기상어".getClass().getName());
		
		System.out.println("----------------------");
		System.out.println(str1==str2);
		System.out.println(str1=="아기상어");
		System.out.println(str1==str3);
		System.out.println("----------------------");
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals("아기상어"));
		System.out.println(str1.equals(str3));
		
		mm.addAttribute("arr", new int[] {33,11,55,88,55,77});
		mm.addAttribute("pname","장서건");
		mm.addAttribute("pid","qqq");
		return "thyme/control";
	}
	
	
	@RequestMapping("lay")
	String lay(Model mm) {
		
		mm.addAttribute("headerUrl", "hd_2");
		mm.addAttribute("pid", "aaa");
		mm.addAttribute("arr", new int[] {77,66,33,99});
		mm.addAttribute("age", 35);
		return "thyme/lalala";
	}
}
