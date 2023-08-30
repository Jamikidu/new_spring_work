package aaa.mymodel;

import java.util.ArrayList;

import aaa.model.OrderAddr;
import aaa.model.OrderData;
import aaa.model.OrderProduct;
import lombok.Data;

@Data
public class Kids implements Comparable<Kids> {
	
	String kname, ban;
	int kor, eng, mat;
	int total, avg;
	int rank;
	

	public int getTotal() {
		total = kor+eng+mat;
		return total;
	}

	public int getAvg() {
		avg = total / 3;
		return avg;
	}

	public void getRank(ArrayList<Kids> karr) {
		rank = 1;
		for(Kids kid : karr) {
			if(total<kid.getTotal()) {
				rank++;
			}
		}
	}

//	@Override
//	public int compareTo(Kids o) {
//		// 'ban' 값을 오름차순으로 비교하여 정렬
//		int res = rank - o.rank;
//		
//		if(res == 0) {
//			res = total.compareTo(o.total);
//		}
//		return res;
//	}
//  내가했던 바보같은 방법
	
	@Override
	public int compareTo(Kids you) {
		
		int res = ban.compareTo(you.ban);
		if(res==0) {
			res = Integer.compare(total, you.total)*-1;
		}
		return res;
	}
		
}