package aop_p.adv;

import org.aspectj.lang.JoinPoint;


public class AdviceAdvice {

	void beforeee(JoinPoint joinPoint) {
		System.out.println(">>> beforeee:"+joinPoint.getSignature().toShortString());
	}
	
	//void afterrr(ProceedingJoinPoint joinPoint) {
	//ProceedingJoinPoint --> around 에서만 사용 가능
	void afterrr(JoinPoint joinPoint) {
		System.out.println(">>> afterrr:"+joinPoint.getSignature().toShortString());
	}
	
	void returnnn(JoinPoint joinPoint, Object qq) {
		System.out.println(">>> returnnn:"+joinPoint.getSignature().toShortString()+" =>"+qq);
	}
	
	void errrr(JoinPoint joinPoint, Throwable ee) {
		System.out.println(">>> errrr:"+joinPoint.getSignature().toShortString()+" =>"+ee.getMessage());
	}
	
}
