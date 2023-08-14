package exam_coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

@Component
public class Coffee implements Coffee_inter{
	
	@Resource(name = "americano")
	Americano ame;
	@Resource(name = "cafeLatte")
	CafeLatte cala;
	@Resource(name = "caramelMacchiato")
	CaramelMacchiato cama;
	

	@Override
	public String toString() {
		return "Coffee [ame=" + ame + ", cala=" + cala + ", cama=" + cama + "]";
	}
	@Override
	public void make() {
		System.out.println("커피를 만듭니다.");
		
	}
	@Override
	public void sell() {
		// TODO Auto-generated method stub
		System.out.println("커피를 팝니다.");
	}
	@Override
	public void drink() {
		// TODO Auto-generated method stub
		System.out.println("커피를 마십니다.");
	}
	
	
}
