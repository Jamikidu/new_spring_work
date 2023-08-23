package aaa.control;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import aaa.mymodel.Cust;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("cust")
public class CustController {
	
	@RequestMapping("loginMain")
	String loginMain(Model mm,
			@CookieValue(value="id", defaultValue = "없음" )String id,
			@CookieValue(value="pname", defaultValue = "없음" )String pname) {
		
		mm.addAttribute("id", id);
		mm.addAttribute("pname", pname);
		return "cust/loginMain";
	}
	
	@RequestMapping("loginReg")
	String loginReg(HttpServletResponse response,
			@RequestParam("id")String id, //param을 안써도 작동함 왜 그런건지...
			@RequestParam("pw")String pw,
			Model mm) {
		ArrayList<Cust> al2 = new ArrayList<>();
		Cust cus1 = new Cust("aaa", "1111", "홍길동");
		Cust cus2 = new Cust("bbb", "2222", "청길동");
		Cust cus3 = new Cust("ccc", "3333", "백길동");
		Cust cus4 = new Cust("ddd", "4444", "주길동");
		al2.add(cus1);
		al2.add(cus2);
		al2.add(cus3);
		al2.add(cus4);
		System.out.println("id: "+id+", pw: "+pw);
		
		String msg = "로그인 실패";
		
		for (Cust cu : al2) {
			if(id.equals(cu.getId()) && pw.equals(cu.getPw())) {
				System.out.println("cu.getPname(): " + cu.getPname());
				msg = cu.getPname()+" 님 로그인 성공";
				response.addCookie(new Cookie("id",cu.getId()));
				response.addCookie(new Cookie("pname",cu.getPname()));
				mm.addAttribute("id",cu.getId());
				mm.addAttribute("pname",cu.getPname());
				mm.addAttribute("msg",msg);
				System.out.println("id:"+cu.getId());
				System.out.println("pname:"+cu.getPname());
				System.out.println("msg:"+msg);
				return "cust/loginAlert";
			}
		}
		mm.addAttribute("msg",msg);
		return "cust/loginAlert";
	}
	
	
//	@PostMapping("login")
//	String loginReg(HttpServletResponse response,
//			@RequestParam("id")String id,
//			@RequestParam("pw")String pw,
//			Model mm
//			) {
//		ArrayList<Cust> al1 = new ArrayList<>();
//		Cust cust1 = new Cust("aaa", "1111", "홍길동");
//		Cust cust2 = new Cust("bbb", "2222", "청길동");
//		Cust cust3 = new Cust("ccc", "3333", "백길동");
//		Cust cust4 = new Cust("ddd", "4444", "주길동");
//		
//		al1.add(cust1);
//		al1.add(cust2);
//		al1.add(cust3);
//		al1.add(cust4);
//		System.out.println("id: "+id+", pw: "+pw);
//		
//		for (Cust cu : al1) {
//			if(id.equals(cu.getId()) && pw.equals(cu.getPw())) {
//				response.addCookie(new Cookie("id",cu.getId()));
//				response.addCookie(new Cookie("pname",cu.getPname()));
//				mm.addAttribute("id",cu.getId());
//				//mm.addAttribute("pw",cu.getPw());
//				mm.addAttribute("pname",cu.getPname());	
//				
//				return "cust/loginView";
//			}
//		}
//
//		return "cust/login";
//	}
	
	
	@RequestMapping("delete")
	String deletecoo(HttpServletResponse response,HttpServletRequest request,
			@CookieValue(value="pname" )String pname) {
		System.out.println("deletecoo() 진입");
		
		Cookie coo = new Cookie("id","");
		coo.setMaxAge(0);
		response.addCookie(coo);
		System.out.println(coo.getValue());
		coo = new Cookie("pname","");
		coo.setMaxAge(0);
		response.addCookie(coo);
		System.out.println(coo.getValue());
		System.out.println("쿠키를 삭제합니다.");
		request.setAttribute("msg", pname+"로그아웃 되었습니다");
		return "redirect:loginAlert";
	}
	
	
	
	
}
