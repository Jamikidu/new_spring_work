package aop_p.classroom;

import java.util.ArrayList;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class AwbAdvice_stud {
	ArrayList<Integer> class1 = new ArrayList<>();
	ArrayList<Integer> class2 = new ArrayList<>();
	ArrayList<Integer> class3 = new ArrayList<>();

	
	void calcSubject2(JoinPoint joinPoint,int a, int b) {
		//System.out.println("calcSubject2(int a,b):"+joinPoint.getSignature().toShortString());
		int tot = a+b;
		int avg = tot/2;
		int avgtot = 0;
		int avgavg = 0;
		System.out.println("과목 2개반 학생의 -- 총점: "+tot+", 평균: "+avg);
		class1.add(avg);
		for(int i : class1) {
			avgtot += i;
			avgavg = avgtot/class1.size();
		}
		System.out.println("과목 2개반의 인원수는: "+class1.size()+", 평균합계: "+avgtot+", 평균의 평균: "+avgavg);
	}
	
	void calcSubject3(JoinPoint joinPoint,int a,int b,int c) {
		//System.out.println("calcSubject3(int a,b,c):"+joinPoint.getSignature().toShortString());
		int tot = a+b+c;
		int avg = tot/3;
		int avgtot = 0;
		int avgavg = 0;
		System.out.println("과목 3개반 학생의 -- 총점: "+tot+", 평균: "+avg);
		class2.add(avg);
		for(int i : class2) {
			avgtot += i;
			avgavg = avgtot/class2.size();
		}
		System.out.println("과목 3개반의 인원수는: "+class2.size()+", 평균합계: "+avgtot+", 평균의 평균: "+avgavg);
	}
	
	void calcSubject4(JoinPoint joinPoint,int a,int b,int c,int d) {
		//System.out.println("calcSubject4(int a,b,c,d):"+joinPoint.getSignature().toShortString());
		int tot = a+b+c+d;
		int avg = tot/4;
		int avgtot = 0;
		int avgavg = 0;
		System.out.println("과목 4개반 학생의 -- 총점: "+tot+", 평균: "+avg);
		class3.add(avg);
		for(int i : class3) {
			avgtot += i;
			avgavg = avgtot/class3.size();
		}
		System.out.println("과목 4개반의 인원수는: "+class3.size()+", 평균합계: "+avgtot+", 평균의 평균: "+avgavg);
	}
	
}
