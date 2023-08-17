package aop_p.neworder;

import org.springframework.stereotype.Component;

@Component
public class NewOrder {
	
	public String name, kind;
	int price;
	
	void order(String name, String kind, int price) {
		System.out.println(name+", "+price+"원 을(를) 주문받았습니다~");
	}

	@Override
	public String toString() {
		return "NewOrder [name=" + name + ", kind=" + kind + ", price=" + price + "]";
	}
	
	
	
}
