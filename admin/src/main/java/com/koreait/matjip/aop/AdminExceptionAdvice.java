package com.koreait.matjip.aop;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.matjip.exception.AdminException;

//관리자와 관련된 모든 요청시 발생하는 예외를 감지할 수 있는 글로벌 exception 핸들러 객체
@ControllerAdvice	//컨트롤러 종류 상관 없이 발생하는 예외를 감지하는 객체
public class AdminExceptionAdvice {

	public ModelAndView handle(AdminException e) {
	ModelAndView mav = new ModelAndView();
	AdminException adminException = new AdminException("관리자 인증이 필요한 서비스입니다.");
	mav.addObject("e", adminException);
	mav.setViewName("admin/error/result");	
	return mav;
	}
	
	
}
