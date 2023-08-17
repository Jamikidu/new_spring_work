package aop_p.adv;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//@Component  가능하지만 용어의 편의상으로 Service로 주로 사용
@Service
@Aspect
public class AnnoAdvice {

	@Before("execution(* aop_p.webToon..* (..))")
	void beforeee(JoinPoint joinPoint) {
		System.out.println(">>> beforeee:"+joinPoint.getSignature().toShortString());
	}
	
	@Pointcut("execution(* aop_p.webToon..* (..))")
	void pppiii() {}
	
	@After("pppiii()")
	void afterrr(JoinPoint joinPoint) {
		System.out.println(">>> afterrr:"+joinPoint.getSignature().toShortString());
	}
	
	@AfterReturning(pointcut = "pppiii()", returning = "qq")
	void returnnn(JoinPoint joinPoint, Object qq) {
		System.out.println(">>> returnnn:"+joinPoint.getSignature().toShortString()+" =>"+qq);
	}
	
	@AfterThrowing(pointcut = "pppiii()", throwing = "ee")
	void errrr(JoinPoint joinPoint, Throwable ee) {
		System.out.println(">>> errrr:"+joinPoint.getSignature().toShortString()+" =>"+ee.getMessage());
	}
	
	/*
	 * 식당 주문을 구현하세요
	 * 
	 * 주문 종류에 따른 개수를 구하세요
	 * 종류
	 * 찌개, 덮밥
	 * 
	 * 가격이 10000 미만인 경우 배달비를 추가하세요
	 * 
	 * 종류와 배달비 계산은 aop, annotation 으로 처리
	*/
}
