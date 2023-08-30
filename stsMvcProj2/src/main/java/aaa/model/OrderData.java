package aaa.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class OrderData {

	OrderAddr ad;
	ArrayList<OrderProduct> arr;
	
	int total;
	
	public int getTotal() {
		total = 0;
		for (OrderProduct op : arr) {
			total += op.getTotal();
		}
		
		return total;
	}
}
