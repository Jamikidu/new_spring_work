package aop_p.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class StudRes {
	
	Map<String, StudData> map = new HashMap();

	public void add(GreenStud gs) {
		StudData sd = null;
		if(map.containsKey(gs.kind)) {
			sd = map.get(gs.kind);
		}else {
			sd = new StudData();
		}
		sd.add(gs);
		map.put(gs.kind, sd);
	}
	
	public void ppp() {
		for (Map.Entry<String, StudData> me : map.entrySet()) {
			System.out.println(me.getKey()+" : "+me.getValue());
		}
	}
}


class StudData{
	int tot, cnt;
	
	void add(GreenStud gs) {
		tot += gs.avg;
		cnt ++;
	}

	@Override
	public String toString() {
		return tot + "\t" + cnt +"\t" + tot/cnt;
	}
	
	
}