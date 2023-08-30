package aaa.model;

import java.util.ArrayList;
import java.util.TreeSet;

import lombok.Data;

@Data
public class Exam {

	ArrayList<Student>arr;
	TreeSet<Student> ts;
	public void rankCalc() {
		for (Student st : arr) {
			st.rankCalc(arr);
		}
	}
	
	public TreeSet<Student> getTs(){
		ts = new TreeSet<>(arr);
		
		return ts;
	}
}
