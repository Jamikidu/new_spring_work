package aaa.control;

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
		mm.addAttribute("arr", new int[] {33,11,55,88,55,77});
		mm.addAttribute("pname","장서건");
		mm.addAttribute("pid","qqq");
		return "thyme/control";
	}
}
