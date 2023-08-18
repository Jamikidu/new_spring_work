package aaa.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.model.OrderData;

@Controller
@RequestMapping("request/order")
public class OrderController {

	@GetMapping
	String orderForm() {
		return "req/orderForm";
	}
	
	@PostMapping
	String oderReg(OrderData od) {
		System.out.println(od);
		od.calcRealtot();
		return "req/orderReg";
	}
}
