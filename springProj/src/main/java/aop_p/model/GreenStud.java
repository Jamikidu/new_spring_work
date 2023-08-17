package aop_p.model;

import org.springframework.stereotype.Component;

@Component
public class GreenStud {
	
	public String name, kind;
	int tot, avg;
	
	public void setJum(int kor, int eng) {
		
		tot = kor + eng;
		avg = tot /2;
	}
	public void setJum(int kor, int eng, int mat) {
		
		tot = kor + eng + mat;
		avg = tot /3;
	}
	
	public void setJum(int kor, int eng, int mat, int art) {
		
		tot = kor + eng + mat + art;
		avg = tot /4;
	}
	@Override
	public String toString() {
		return "GreenStud [kind=" + kind + ", name=" + name + ", tot=" + tot + ", avg=" + avg + "]";
	}

	
}
