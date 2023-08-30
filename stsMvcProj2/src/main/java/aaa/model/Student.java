package aaa.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Student implements Comparable<Student>{

	String name;
	List<Double>jum;
	double tot, avg;
	int rank;
	
	
	
	public double getTot() {
		tot = 0;
		for (Double i : jum) {
			tot += i;
		}
		return tot;
	}
	
	public double getAvg() {
		avg = getTot()/jum.size();
		return avg;
	}
	
	public void rankCalc(ArrayList<Student>arr) {
		rank = 1;
		for (Student you : arr) {
			if(avg < you.avg) {
				rank++;
			}
			
		}
	}

	@Override
	public int compareTo(Student o) {
		int res = rank - o.rank;
		if(res==0) {
			res = name.compareTo(o.name);
		}
		return res;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, double... jum) {
		super();
		this.name = name;
		this.jum = new ArrayList<>();
		for (Double i : jum) {
			this.jum.add(i);
		}
	}
}
