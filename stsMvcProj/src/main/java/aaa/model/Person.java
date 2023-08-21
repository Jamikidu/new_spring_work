package aaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Person {
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String pname, String gender, boolean mil) {
		super();
		this.pname = pname;
		this.gender = gender;
		this.mil = mil;
	}
	
	public Person(String pname, String gender, String age, boolean mil, boolean mar) {
		super();
		this.pname = pname;
		this.gender = gender;
		this.age = age;
		this.mil = mil;
		this.mar = mar;
	}

	String pname, gender, age, id;
	boolean mil, mar;
	
}
