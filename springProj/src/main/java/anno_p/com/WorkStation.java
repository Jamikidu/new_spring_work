package anno_p.com;

import anno_p.com.sub1.Mouse;
import anno_p.comabc.Monitor;

public class WorkStation {
	String name;
	
	Bonche bon;
	
	Monitor m1, m2;
	
	Mouse mm;

	public WorkStation(String name, Bonche bon, Monitor m1, Monitor m2, Mouse mm) {
		super();
		this.name = name;
		this.bon = bon;
		this.m1 = m1;
		this.m2 = m2;
		this.mm = mm;
	}

	@Override
	public String toString() {
		return "WorkStation [name=" + name + ", bon=" + bon + ", m1=" + m1 + ", m2=" + m2 + ", mm=" + mm + "]";
	}
	
}
