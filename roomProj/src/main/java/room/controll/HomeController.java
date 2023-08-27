package room.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	//@ResponseBody
	String homeGo() {
		System.out.println("팀1 홈이다");
		//return "homehome";
		return "home";  // views/home.html
	}
}
