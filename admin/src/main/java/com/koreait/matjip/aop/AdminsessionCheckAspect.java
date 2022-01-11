package com.koreait.matjip.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.matjip.exception.AdminException;

public class AdminsessionCheckAspect {
	//관리자로 들어오는 요청에 대한 검열을 시도할 수 있는 메서드 정의
	public Object sessionCheck(ProceedingJoinPoint joinPoint) throws Throwable{
		Object result=null;	//최종적으로 반환될 반환값

		//원래 호출하려던 타겟이 되는 객체
		Object target=joinPoint.getTarget();
		Class targetClass = target.getClass();
		Signature method= joinPoint.getSignature();
		Object[] args=joinPoint.getArgs();	//원래 타겟이 보유한 메서드의 매개 변수
		
		//HttpServeletRequest가 몇번째 있는지 알수 없으므로 반복문으로 잡아낸다
		HttpServletRequest request=null;
		for(int i=0;i<args.length;i++) {
			if(args[i] instanceof HttpServletRequest) {
				request=(HttpServletRequest)args[i];				
			}			
		}		
		System.out.println("원래 호출하려던 컨트롤러와 메서드는 "+targetClass.getName()+", "+method);
		
		//세션이 존재하는지 체크
		HttpSession session=request.getSession();
		
		
		if(session.getAttribute("admin")==null) {
			//로그인 에러페이지
			ModelAndView mav = new ModelAndView();
			result = mav;
			AdminException adminException = new AdminException("관리자 인증이 필요한 서비스입니다.");
			mav.addObject("e", adminException);
			mav.setViewName("admin/error/result");						
		}else {
			joinPoint.proceed();	//원래 호출하려던 target의 메서드 호출			
		}		
		return result;
	}
}
