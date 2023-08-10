package di_p;

import java.util.Arrays;
import java.util.List;


public class Stud implements Comparable<Stud>{

	String name;
	int [] jum;
	int tot, avg, rank;
	public void setName(String name) {
		this.name = name;
	}
	public void setJum(int... jum) {
		this.jum = jum;
		tot = 0;
		for (int i : jum) {
			tot += i;
		}
		avg = tot / jum.length;
	}
	
	void rankCalc(List<Stud> studs) {
		rank = 1;
		for (Stud you : studs) {
			if(avg < you.avg) {
				rank++;
			}
		}
	}
	@Override
	public String toString() {
		return "" + name + "\t" + Arrays.toString(jum) + "\t" + tot + "\t" + avg + "\t"+rank;
	}
	@Override
	public int compareTo(Stud you) {
		
		int res = rank - you.rank;
		
		if(res == 0) {
			res = name.compareTo(you.name);
		}
		return res;
	}
	
	
}
