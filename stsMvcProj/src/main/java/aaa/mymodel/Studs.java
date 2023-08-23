package aaa.mymodel;

import java.util.ArrayList;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Studs {

	String sname;
	int[] jum;
	int avg,tot;
	
	
	public int getAvg() {
		avg = getTot()/jum.length;
		return avg;
	}
	public int getTot() {
		tot = 0;
		for(int i:jum) {
			tot += i;
		}
		return tot;
	}
	
	public Studs(String sname, int... jum) {
		super();
		this.sname = sname;
		this.jum = jum;
	}
	
	
	
}
