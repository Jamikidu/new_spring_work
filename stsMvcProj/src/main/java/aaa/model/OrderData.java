package aaa.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class OrderData {

	OrderAddr ad;
	ArrayList<OrderProduct> arr;
	int realtot;
	
	
	
	public int calcRealtot() {
		
		for (OrderProduct a : arr) {
			realtot += a.total;
		}
		
		
//		for(int i=0;i<arr.size();i++) {
//			realtot += arr.get(i).total;
//		}
		
		return realtot;
	}
	
}
