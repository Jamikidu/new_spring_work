package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("cookie")
public class CookieController {

	@RequestMapping("make1")
	@ResponseBody
	String make1(HttpServletResponse response) {
		
		response.addCookie(new Cookie("pid","ccc"));
		response.addCookie(new Cookie("age","27"));
		return "쿠키생성1";
	}
	
	
	@RequestMapping("make2")
	@ResponseBody
	String make2(HttpServletResponse response) {
		
		response.addCookie(new Cookie("pid","ddd"));
		response.addCookie(new Cookie("marriage","true"));
		return "쿠키생성2";
	}
	
	@RequestMapping("delete")
	@ResponseBody
	String delete(HttpServletResponse response) {
		Cookie coo = new Cookie("pid","");
		coo.setMaxAge(0);
		response.addCookie(coo);
		
		coo = new Cookie("age","5");
		coo.setMaxAge(5);
		response.addCookie(coo);
		
		return "쿠키삭제";
	}
	
	
	@RequestMapping("view")
	
	ModelAndView view(
			@CookieValue(value="pid", defaultValue = "없음" )String pid,
			@CookieValue(value="age", defaultValue = "0" )int age,
			@CookieValue(value="marriage", defaultValue = "false" )boolean marriage) {
		
		ModelAndView mav = new ModelAndView("cookie/view");
		mav.addObject("pid",pid);
		mav.addObject("age",age);
		mav.addObject("marriage",marriage);
		return mav;
	}
}
