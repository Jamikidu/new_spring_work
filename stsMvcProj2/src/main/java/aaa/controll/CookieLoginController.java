package aaa.controll;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import aaa.model.Person;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("cookie")
public class CookieLoginController {

	
	@RequestMapping("loginReg")
	ModelAndView  make1(
			String pid, String pw,
			HttpServletResponse response) {
		
		HashMap<String, Person>map = new HashMap<>();
		map.put("aaa", new Person("aaa", "장동건" , "1111"));
		map.put("bbb", new Person("bbb", "장서건", "222"));
		map.put("ccc", new Person("ccc", "장동건", "3333"));
		map.put("ddd", new Person("ddd", "장남건", "1111"));
		map.put("eee", new Person("eee", "북두신건", "3333"));

		
		ModelAndView mav = new ModelAndView("cookie/loginAlert");
		String msg = "로그인 실패";
		if(map.containsKey(pid) && map.get(pid).getPw().equals(pw)) {
			msg = map.get(pid).getPname()+" 로그인 성공";
			response.addCookie(new Cookie("pid",pid));
			response.addCookie(new Cookie("pname", map.get(pid).getPname()));
		}
		mav.addObject("msg", msg);
		return mav;
	}
	
	
	@RequestMapping("logout")
	ModelAndView delete(
			@CookieValue(value="pname" )String pname,
			HttpServletResponse response) {
		Cookie coo = new Cookie("pid","");
		coo.setMaxAge(0);
		response.addCookie(coo);
		
		coo = new Cookie("pname","");
		coo.setMaxAge(0);
		response.addCookie(coo);
		ModelAndView mav = new ModelAndView("cookie/loginAlert");
		
		mav.addObject("msg", pname+"로그아웃 되었습니다");
		return mav;
	}
	
	
	@RequestMapping("loginMain")
	ModelAndView view(
			@CookieValue(value="pid", defaultValue = "없음" )String pid,
			@CookieValue(value="pname", defaultValue = "없음" )String pname) {
		
		ModelAndView mav = new ModelAndView("cookie/loginMain");
		mav.addObject("pid",pid);
		mav.addObject("pname",pname);
		return mav;
	}
}
