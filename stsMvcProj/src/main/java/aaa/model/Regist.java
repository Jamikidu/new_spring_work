package aaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Regist {
	
	public Regist() {
		// TODO Auto-generated constructor stub
	}
	
	public Regist(String id, String pw, String pname, String gender) {
		super();
		this.id = id;
		this.pw = pw;
		this.pname = pname;
		this.gender = gender;
	}

	String id, pw, pname, gender;
	
}
