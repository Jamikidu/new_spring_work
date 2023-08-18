package aaa.model;

import lombok.Data;

@Data
public class OrderProduct {

	String pname;
	public int price, cnt, total;
	
	public int getTotal() {
		total = price * cnt;
		return total;
	}

	
}
