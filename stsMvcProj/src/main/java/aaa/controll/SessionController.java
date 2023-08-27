package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import aaa.model.Student;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("session")
public class SessionController {

	@RequestMapping("make1")
	@ResponseBody
	String make1(HttpSession session) {
		
		session.setAttribute("pname", "장동건");
		session.setAttribute("no", 123.456);
		session.setAttribute("arr", new int[]{33,55,11,88});
		session.setAttribute("st", new Student("이효리",77,86,92));
		
		return "세션 설정1";
	}
	
	@RequestMapping("make2")
	@ResponseBody
	String make2(HttpSession session) {
		
		session.setAttribute("pname", "장서건");
		session.setAttribute("age", 38);
		session.setAttribute("no", 123.456);
		session.setAttribute("arr", new int[]{33,55,11,88});
		session.setAttribute("st", new Student("이효리",77,86,92));
		
		return "세션 설정2";
	}
	
	@RequestMapping("delete")
	@ResponseBody
	String delete(HttpSession session) {
		
		//session.removeAttribute("no");  부분
		//session.removeAttribute("arr"); 삭제
		session.invalidate();
		
		return "세션 삭제";
	}
	
	@RequestMapping("view")
	String view(HttpSession session) {
		System.out.println("view-------------------");
		System.out.println(session.getAttribute("pname"));
		System.out.println(session.getAttribute("no"));
		System.out.println(session.getAttribute("arr"));
		System.out.println(session.getAttribute("st"));
		System.out.println(session.getAttribute("age"));
		
		return "session/view";
	}
}
