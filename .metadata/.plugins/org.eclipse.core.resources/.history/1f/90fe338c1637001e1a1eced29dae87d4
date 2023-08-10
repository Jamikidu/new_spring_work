package di_p;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Set_iterator {
	
	public static void main(String[] args) {
		//Set과 iterator 연습
		
		Set<String> set1 = new HashSet<String>();
		set1.add("숫자0");
		set1.add("숫자1");
		set1.add("숫자2");
		set1.add("숫자3");
		set1.add("숫자4");
		set1.add("숫자5");
		set1.add("숫자6");
		set1.add("숫자7");
		set1.add("숫자8");
		set1.add("숫자9");
		
		System.out.println("set1의 저장된 데이터 수: "+set1.size());
		
		Iterator<String> it = set1.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("=============================");
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		// iterator 재선언을 안해줘서 값이 안나옴
		it = set1.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		Set<String> ts = new TreeSet<String>();
		ts.add("a");
		ts.add("c");
		ts.add("d");
		ts.add("b");

		Iterator<String> itr = ts.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		/*
		LinkedHashSet<Integer> lh = new LinkedHashSet<Integer>();
		lh.add(1);
		lh.add(1);
		lh.add(4);
		lh.add(2);
		lh.add(3);
		Iterator<Integer> it2 = lh.iterator();

		while (it2.hasNext()) {
			System.out.println(it2.next());
		}
		*/
	}
	
	
}
