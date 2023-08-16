package aop_p.adv;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class ExecAdvice2 {

	
	void ok(JoinPoint joinPoint) {
		System.out.println("ExecAdvice2 - ok:"+joinPoint.getSignature().toShortString());
	}
	
	void oOrJo(JoinPoint joinPoint) {
		System.out.println("ExecAdvice2 - oOrJo:"+joinPoint.getSignature().toShortString());
	}
}
