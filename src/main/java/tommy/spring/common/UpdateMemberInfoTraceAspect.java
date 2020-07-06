package tommy.spring.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import tommy.spring.member.vo.UpdateInfo;


@Aspect
@Order(3)
public class UpdateMemberInfoTraceAspect {
	
	//xml에서는 joinpoint를 썼지만 여기서는 쓰지 않는다. xml에서는 메소드 확인이 안되서 적은 것
	@AfterReturning(pointcut = "args(memberId,info)", returning = "result",argNames = "result, memberId, info")
		public void traceReturn(JoinPoint joinPoint, boolean result, String memberId, UpdateInfo info) {
			System.out.println("[TA] 정보 수정 : 결과 = " + result + ", 대상회원 = " + memberId + ", 수정정보 = " + info);
		}
}
