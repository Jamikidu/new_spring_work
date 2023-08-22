package aaa.control;

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

	@RequestMapping("loginMain")	//cookie/loginMain url로 이동
	ModelAndView view(
			@CookieValue(value="pid", defaultValue = "없음" )String pid,  //쿠키 전달 받을 이름 pid로 지칭, 없으면 "없음"표시
			@CookieValue(value="pname", defaultValue = "없음" )String pname) {  //쿠키 전달 받을 이름 pname로 지칭, 없으면 "없음"표시
		
		ModelAndView mav = new ModelAndView("cookie/loginMain"); //이동 할 페이지 지정
		mav.addObject("pid",pid);  //model에 "pid"라는 String pid값 추가
		mav.addObject("pname",pname);  //model에 "pname"라는 String pname값 추가
		return mav;
	}
	
	@RequestMapping("loginReg")		//cookie/loginReg url로 이동
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
	
	
	
}
