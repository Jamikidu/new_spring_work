package aaa.controll;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aaa.model.OrderData;

@Controller
@RequestMapping("request/coffee")
public class CoffeeController {
	
	HashMap<String, Integer>menu;
	
	public CoffeeController() {
		menu = new HashMap<>();
		menu.put("아메리카노", 2200);
		menu.put("아프리카노", 2300);
		menu.put("아시아노", 2500);
	}

	@GetMapping
	String orderForm(Model mm) {
		mm.addAttribute("menu", menu);
		return "req/coffeeForm";
	}
	
	@PostMapping
	String orderReg(
			Model mm,
			@RequestParam("menu")String mu, 
			@RequestParam(value="cnt", defaultValue = "1")int cnt) {
		int total = menu.get(mu) * cnt;
		mm.addAttribute("price", menu.get(mu));
		mm.addAttribute("total", total);
		System.out.println(mu+":"+cnt+"=>"+total);
		return "req/coffeeReg";
	}
}
