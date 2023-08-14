package anno_p.comabc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import anno_p.com.Bonche;
import anno_p.com.sub1.Mouse;
import jakarta.annotation.Resource;

@Component
public class NoteBook {
	
	
	Bonche bc;
	@Resource
	Mouse mouse;
	
	String name = "삼보그램";
	
	@Autowired //@Bean 걸어주는것보다 우선순위가 더 높음
	public void setBc(Bonche bc) {
		System.out.println(name+"setBc() 실행:"+bc);
		this.bc = bc;
	}


	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "NoteBook [bc=" + bc + ", mouse=" + mouse + ", name=" + name + "]";
	}
	
}
