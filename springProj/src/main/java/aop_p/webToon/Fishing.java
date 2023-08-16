package aop_p.webToon;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Fishing {
	
	public String fish() {
		//System.out.println("미끼가 없네요...");
		return null;
	}

	public String fish(String bait,int centi) { //bait=미끼
		//String fish = "붕어";
		Random ran = new Random();
		String[] fishes = {"고등어","연어","도미","참치","청어","가물치","복어","잉어","오징어","갈치"
							,"서대","광어","도다리","가자미","돌돔","굴비","감성돔","굴젓굴비","새우멸치","삼치"};
		String ran2 = fishes[ran.nextInt(fishes.length)];
		System.out.println(bait+"를(을) 써서 물고기를 낚았다! || 이름이 뭐니? "+ran2+", "+centi+"cm");
		return ran2;
	}
	
}
