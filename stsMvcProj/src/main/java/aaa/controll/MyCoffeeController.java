package aaa.controll;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/request/coffeeHome")
public class MyCoffeeController {
	
	HashMap<String,Integer> menu;
	
	public MyCoffeeController() {
		menu = new HashMap<>();
		menu.put("아메리카노", 2200);
		menu.put("카페라떼", 3100);
		menu.put("카라멜마끼아또", 3800);
	}
	
	@GetMapping
	String coffeeOrder(Model mm) {
		mm.addAttribute("menu", menu);
		return "req/MyCoffeeOrder";
	}
	
	@PostMapping
	String coffeeReg(
			Model mm,
			@RequestParam("type")String type,
			@RequestParam(value="cup", defaultValue = "1")int cup) {
		int total = menu.get(type)*cup;
		mm.addAttribute("price",menu.get(type));
		mm.addAttribute("total",total);
		System.out.println(type+":"+cup+"=>"+total);
		
		return "req/MyCoffeeReg";
	}
	

	@RequestMapping("coffee")
	String coffee(
			@RequestParam(value="brand", required = false)String brand,
			@RequestParam(value="type")String coffeetype,
			@RequestParam(value="cup", required = false, defaultValue = "1")int cup,
			@RequestParam(value="pr")int price) {
		
		System.out.println("브랜드명: "+brand+", 커피이름: "+coffeetype+", 잔수: "+cup+"잔, 1잔당 금액: "+price+", 총금액: "+price*cup);
		return "req/coffee";
	}
}
