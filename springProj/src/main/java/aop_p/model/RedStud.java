package aop_p.model;

import org.springframework.stereotype.Component;

@Component
public class RedStud {
	
	String name, kind;
	int tot;
	double avg;
	
	public void setJum(int kor, int eng) {
		kind = "직장인";
		tot = kor + eng;
		avg = kor * 0.9 + eng * 0.1;
	}
	public void setJum(int kor, int eng, int mat) {
		kind = "일반";
		tot = kor + eng + mat;
		avg = kor * 0.7 + eng * 0.1 + mat * 0.2;
	}
	
	public void setJum(int kor, int eng, int mat, int art) {
		kind = "예체능";
		tot = kor + eng + mat + art;
		avg = kor * 0.15 + eng * 0.1 + mat * 0.2 + art * 0.65;
	}
	@Override
	public String toString() {
		return "RedStud [kind=" + kind + ", name=" + name + ", tot=" + tot + ", avg=" + avg + "]";
	}

	
}
