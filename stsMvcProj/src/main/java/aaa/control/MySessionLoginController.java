package aaa.control;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import aaa.model.Person;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("mysession")
public class MySessionLoginController {

	@RequestMapping("loginMain")	
	ModelAndView view(
			HttpServletResponse response,
			HttpSession session) {

		
		ModelAndView mav = new ModelAndView("session/loginMain"); 

		return mav;
	}
	
	@RequestMapping("loginReg")
	ModelAndView make1(
			String pid, String pw,
			HttpServletResponse response,
			HttpSession session) {
		
		
		
		HashMap<String, Person>map = new HashMap<>();
		map.put("aaa", new Person("aaa", "장동건" , "1111"));
		map.put("bbb", new Person("bbb", "장서건", "222"));
		map.put("ccc", new Person("ccc", "장북건", "3333"));
		map.put("ddd", new Person("ddd", "장남건", "1111"));
		map.put("eee", new Person("eee", "북두신건", "3333"));

		
		ModelAndView mav = new ModelAndView("session/loginAlert");
		String msg = "로그인 실패";
		if(map.containsKey(pid) && map.get(pid).getPw().equals(pw)) {
			msg = map.get(pid).getPname()+" 로그인 성공";
			session.setAttribute("pid",pid);
			session.setAttribute("pname",map.get(pid).getPname());
		}
		mav.addObject("msg", msg);
		return mav;
	}
	
	@RequestMapping("loginReg2")
	String make2(
			String pid, String pw,
			HttpServletResponse response, HttpServletRequest request,
			HttpSession session) {
		
		System.out.println(pid);
		System.out.println(pw);
		HashMap<String, Person>map = new HashMap<>();
		map.put("aaa", new Person("aaa", "장동건" , "1111"));
		map.put("bbb", new Person("bbb", "장서건", "222"));
		map.put("ccc", new Person("ccc", "장북건", "3333"));
		map.put("ddd", new Person("ddd", "장남건", "1111"));
		map.put("eee", new Person("eee", "북두신건", "3333"));

		
		//ModelAndView mav = new ModelAndView("session/loginAlert");
		String msg = "로그인 실패";
		if(map.containsKey(pid) && map.get(pid).getPw().equals(pw)) {
			msg = map.get(pid).getPname()+" 로그인 성공";
			session.setAttribute("pid",pid);
			session.setAttribute("pname",map.get(pid).getPname());
			request.setAttribute("msg", msg);
			return "session/loginAlert";
		}
		request.setAttribute("msg", msg);
		return "session/loginAlert";
	}
	
	@RequestMapping("logout")
	ModelAndView delete(
			HttpSession session,
			HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView("session/loginAlert");
		
		mav.addObject("msg", session.getAttribute("pname")+" 로그아웃 되었습니다");
		session.invalidate();
		return mav;
	}
}
