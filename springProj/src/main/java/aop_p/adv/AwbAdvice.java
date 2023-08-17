package aop_p.adv;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class AwbAdvice {

	void js(JoinPoint joinPoint) {
		System.out.println("js:"+joinPoint.getSignature().toShortString());
	}
	
	void kkbbdd(JoinPoint joinPoint) {
		System.out.println("kkbbdd:"+joinPoint.getSignature().toShortString());
	}
	
	void qw(JoinPoint joinPoint,int qq, String ww) {  //dog1 메서드 조건과 일치
		System.out.println("qw(int,string):"+joinPoint.getSignature().toShortString()+"=>"+qq+","+ww);
	}
	
	void zx(JoinPoint joinPoint,int zz, int xx) {  //dog1 메서드의 매개변수는 int,string 이기 때문에 조건에 걸리지 않음
		System.out.println("zx(int,int):"+joinPoint.getSignature().toShortString());
	}
	
	void cccc(JoinPoint joinPoint,int cc) {  //papa 메서드 조건과 일치
		System.out.println("cc(int):"+joinPoint.getSignature().toShortString());
	}
	
	void oAndKang(JoinPoint joinPoint) {
		System.out.println("oAndKang:"+joinPoint.getSignature().toShortString());
	}
	
	void oOrJo(JoinPoint joinPoint) {
		System.out.println("oOrJo:"+joinPoint.getSignature().toShortString());
	}
}
