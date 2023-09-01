package bbb.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping("/")
	//@ResponseBody
	String supulHome() {
		System.out.println("SUPUL팀 홈");
		//return "homehome";
		return "testHome";  // views/home.html
	}	 
}
