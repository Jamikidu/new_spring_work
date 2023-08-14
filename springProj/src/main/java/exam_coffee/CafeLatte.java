package exam_coffee;

import org.springframework.stereotype.Component;

@Component
public class CafeLatte extends Americano{
	
	//String beans 정의 안해줘도 extends 해줬기때문에 값이 이미 들어가있음
	String water = "생수";
	String milk = "서울우유";
	int price = 2900;
	
	@Override
	public String toString() {
		return "CafeLatte [beans=" + beans + ", water=" + water + ", milk=" + milk + ", price=" + price + "]";
	}
	
}
