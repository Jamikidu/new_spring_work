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
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("session")
public class SessionLoginController {

	
	@RequestMapping("loginReg")
	String loginReg(Person per, HttpSession session) {
		
		HashMap<String, Person>map = new HashMap<>();
		map.put("aaa", new Person("aaa", "장동건" , "1111"));
		map.put("bbb", new Person("bbb", "장서건", "222"));
		map.put("ccc", new Person("ccc", "장동건", "3333"));
		map.put("ddd", new Person("ddd", "장남건", "1111"));
		map.put("eee", new Person("eee", "북두신건", "3333"));
		//System.out.println("체크 확인"+per);
		per.setMsg("로그인 실패");
		if(map.containsKey(per.getId())) {
			Person mPer = map.get(per.getId());
			
			if(mPer.idPwChk(per)) {
		
				per.setMsg(mPer.getPname()+"님 로그인 성공");
				session.setAttribute("per", mPer);
			}
		}
		
		return "session/loginAlert";
	}
	
	
	@RequestMapping("logout")
	String delete(Person per ,HttpSession session) {
		
		per.setMsg(((Person)session.getAttribute("per")).getPname()+"로그아웃 되었습니다");
		session.invalidate();
		return "session/loginAlert";
	}
	
	
	@RequestMapping("loginMain")
	String view() {
		
		return "session/loginMain";
	}
}
