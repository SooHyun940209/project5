package tommy.spring.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class LoggingAspect {
	
	@Before("PublicPointcut.publicMethod()") //메소드 이름이 id가 되어 괄호까지 들어와야함
	public void before() {
		System.out.println("[LA] 메소드 실행 전 전처리 수행");
	}
	
	@AfterReturning(pointcut = "tommy.spring.common.PublicPointcut.publicMethod()",returning = "ret")
	public void afterReturning(Object ret) {
		System.out.println("[LA] 메소드 실행 후 후처리 수행, 리턴값 = " + ret);
	}
	
	@AfterThrowing(pointcut = "tommy.spring.common.PublicPointcut.publicMethod()",throwing = "ex")
	public void afterThrowing(Throwable ex) {
		System.out.println("[LA] 메소드 실행 중 예외 발생, 예외 = " + ex.getClass().getName());
	}
	
	@After("tommy.spring.common.PublicPointcut.publicMethod()")
	public void afterFinally() {
		System.out.println("[LA] 메소드 실행 완료 후 무조건 처리");
	}
}
