package aop_p.adv;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class ExecAdvice1 {

	void retString(JoinPoint joinPoint) {
		System.out.println("retString:"+joinPoint.getSignature().toShortString());
	}
	
	void paramInt(JoinPoint joinPoint) {
		System.out.println("paramInt:"+joinPoint.getSignature().toShortString());
	}
	
	void nameDog(JoinPoint joinPoint) {
		System.out.println("nameDog:"+joinPoint.getSignature().toShortString());
	}
	
	void claKang(JoinPoint joinPoint) {
		System.out.println("claKang:"+joinPoint.getSignature().toShortString());
	}
	
	void endO(JoinPoint joinPoint) {
		System.out.println("endO:"+joinPoint.getSignature().toShortString());
	}
	
	void oAndKang(JoinPoint joinPoint) {
		System.out.println("oAndKang:"+joinPoint.getSignature().toShortString());
	}
	
	void oOrJo(JoinPoint joinPoint) {
		System.out.println("oOrJo:"+joinPoint.getSignature().toShortString());
	}
}
