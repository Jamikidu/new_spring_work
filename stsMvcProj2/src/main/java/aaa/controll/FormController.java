package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import aaa.model.MemData;
import aaa.model.Person;

@Controller
@RequestMapping("/form")
public class FormController {

	@GetMapping("form")
	String form(MemData md) {
		return "form/form";
	}
	
	@GetMapping("link")
	String link(Model mm) {
		mm.addAttribute("cate1", "eee");
		mm.addAttribute("cate2", "fff");
		mm.addAttribute("no", 2);
		mm.addAttribute("age", 34);
		mm.addAttribute("pid", "qwer");
		return "form/link";
	}
	
	@GetMapping("{cate}")
	@ResponseBody
	String link2(@PathVariable String cate, Person per) {
		String ttt = "cate:"+cate+"<br/>";
		ttt += per+"<br/>";
		return ttt;
	}
	
	@GetMapping("{ct1}/{ct2}")
	@ResponseBody
	String link3(@PathVariable String ct1,@PathVariable String ct2, Person per) {
		String ttt = "ct1:"+ct1+"<br/>";
		ttt += "ct2:"+ct2+"<br/>";
		ttt += per+"<br/>";
		return ttt;
	}
}
