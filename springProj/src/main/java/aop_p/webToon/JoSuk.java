package aop_p.webToon;

import org.springframework.stereotype.Component;

@Component
public class JoSuk {
	

	public String dog1(int aa, String bb) {
		System.out.println("센세이션은 찢찢:"+aa+", "+bb);
		return "센세이션";
	}
	
	public String wife() {
		System.out.println("애봉파워");
		return "애봉";
	}
	
	public int papa(int c) {
		System.out.println("조철왕:"+c);
		return 4000;
	}
	
	public int nums(int c) {
		System.out.println("nums:"+c);
		return 100/c; 
	}
}
