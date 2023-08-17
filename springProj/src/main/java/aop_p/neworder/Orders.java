package aop_p.neworder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Orders {
	
	Map<String, Integer> 찌개 = new HashMap();
	Map<String, Integer> 덮밥 = new HashMap();

	public void add(NewOrder nod) {
		if(nod.kind.equals(찌개)) {
			찌개.put(nod.name, nod.price);
		}else {
			덮밥.put(nod.name, nod.price);
		}

	}
	public void show찌개() {

		if(찌개.size()!=0) {
			System.out.println(찌개);
		}else {
			System.out.println("찌개종류 주문이 없습니다.");
		}
	}
	public void show덮밥() {

		if(덮밥.size()!=0) {
			System.out.println(덮밥);
		}else {
			System.out.println("덮밥종류 주문이 없습니다.");
		}
	}

}