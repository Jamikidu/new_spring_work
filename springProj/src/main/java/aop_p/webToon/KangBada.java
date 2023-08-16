package aop_p.webToon;

import java.util.HashMap;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component("kbd")
public class KangBada {
	
	HashMap<String, KangFish>map;
	
	Random rd;
	
	public KangBada() {
		rd = new Random();
		map = new HashMap<>();
		
		map.put("지렁이", new KangFish("붕어", rd.nextInt(10, 40)));
		map.put("새우", new KangFish("잉어",  rd.nextInt(10, 40)));
		map.put("떡밥", new KangFish("인어", rd.nextInt(10, 40)));
		map.put("오징어", new KangFish("어인", rd.nextInt(10, 40)));
	}

	public KangFish fishing(String ... lur ) {
		System.out.println(lur[0]+"로 낚시해요");
		
		
		return map.get(lur[0]);
	}
	
	public void dogdo() {
		System.out.println("독도에서 낚시해요.");
	}
}


