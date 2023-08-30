package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.model.EscapeData;
import aaa.model.MemData;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	@GetMapping("exerForm1")
	String exerForm1(EscapeData ed) {
		return "review/exerForm1";
	}
}
