package aaa.model;

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
	String pname, gender, id, pw, msg;
	int age, no;
	boolean mil, marriage;
	public Person(String id, String pname, String pw) {
		super();
		this.id = id;
		this.pname = pname;
		this.pw = pw;
	}
	
	public boolean idPwChk(Person other) {
	
		
		return id.equals(other.id) && pw.equals(other.pw);
	}
	
	
}
