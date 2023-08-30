package aaa.controll;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.service.MyProvider;
import jakarta.annotation.Resource;

@Controller
@RequestMapping("/provider")
public class ProviderController {
	
	@Resource
	MyProvider provider;
	
	@ModelAttribute("cam")
	Object mm() {
		Object res = provider.getContext().getBean("camera");
		System.out.println("mm() 실행:"+res);
		return res;
	}
	
	
	

	@RequestMapping("list")
	String mapping1() {
		return "provider/view";
	}
	
	@RequestMapping("{bbb}")
	String mapping2(@PathVariable String bbb, Model mm) {
		
		mm.addAttribute("bat",provider.getContext().getBean(bbb));
		return "provider/view";
	}
}
