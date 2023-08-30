package aaa.mymodel;

import lombok.Data;

@Data
public class Cust {
	String id,pw,pname;

	public Cust(String id, String pw, String pname) {
		super();
		this.id = id;
		this.pw = pw;
		this.pname = pname;
	}
	
}
