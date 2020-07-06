package tommy.spring.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class ProfilingAspect {
	//spring.board.service.. 으로 해야 service에만 걸림
	@Pointcut("execution(public * tommy.spring..*(..))")
	private void profileTarget() {
	}
	
	@Around("profileTarget()")
	public Object trace(ProceedingJoinPoint joinPoint)throws Throwable{
		String method = joinPoint.getSignature().toShortString();
		System.out.println(method + " 시작");
		long start = System.currentTimeMillis();
		try {
			Object result = joinPoint.proceed();
			return result;
		}finally {
			long finish = System.currentTimeMillis();
			System.out.println(method + " 종료");
			System.out.println(method + " 실행 시간 : " + (finish - start) + "ms");
		}
	}
}
