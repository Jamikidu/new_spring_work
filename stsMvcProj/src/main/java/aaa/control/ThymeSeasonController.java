package aaa.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("thymeleaf")
public class ThymeSeasonController {

	
	@RequestMapping("lay2")
	String lay2(Model mm) {
		
		mm.addAttribute("headerUrl", "hd_2");
		mm.addAttribute("pid","aaa");
		mm.addAttribute("arr",new int[] {77,66,33,99});
		mm.addAttribute("age", 35);
		
		return "model/dummy";
	}

}
