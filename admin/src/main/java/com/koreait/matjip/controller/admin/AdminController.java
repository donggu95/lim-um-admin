package com.koreait.matjip.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.matjip.domain.Admin;
import com.koreait.matjip.exception.AdminException;
import com.koreait.matjip.model.admin.AdminService;
import com.koreait.matjip.util.HashBuilder;
import com.koreait.matjip.util.Message;


//관리자 인증과 관련된 요청을 처리하는 하위 컨트롤러

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private HashBuilder hashBuilder;
		
	//로그인 폼 요청 처리
	@GetMapping("/login/form")
	public String getLoginForm() {
		
		return "admin/login/loginform";
		
		
	}
	//로그인 요청 처리
	@PostMapping("/login")
	@ResponseBody	//return 값에 반환된 data를 viewResolver가 해석하는게 아니라 
							//메서드의 반환형으로 명시된 데이터자체를 응답 데이터로 전송
	public Message loginCheck(HttpServletRequest request, Admin admin) {
		
		//서비스에게 일 시키기 전에 비밀번호를 hash값으로 변환해서 비교
		//db의 hash값과 변환한 hash값이 틀린 경우 인증 실패
		String pass=hashBuilder.convertStringToHash(admin.getPass());
		admin.setPass(pass);

		Admin result=adminService.select(admin);
		
		Message message = new Message();
		message.setCode(1);
		
		message.setMsg("인증 성공");
		
		//클라이언트가 재접속시 데이터를 사용할 수 있도록 session에 result를 
		HttpSession session=request.getSession();
		session.setAttribute("admin", result);	//세션에 DTO 저장
		
		return message;
	}
	
	//로그아웃 요청 처리
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/admin/login/form";
		
	}
	
	
	@ExceptionHandler(AdminException.class)
	@ResponseBody
	public ResponseEntity<Message> handle(AdminException e) {
		HttpHeaders header=new HttpHeaders();
		header.add("Content-Type", "text/html;charset=utf-8");
		//한글 및 제대로 된 응답 정보를 구성하려면 REsponseEntity header, body

		Message message = new Message();
		message.setCode(0);
		message.setMsg(e.getMessage());
		
		ResponseEntity<Message> entity= new ResponseEntity(e.getMessage(), HttpStatus.OK);
		return entity;
	}
	
	@ExceptionHandler(AdminException.class)
	public ModelAndView handle2(AdminException e) {
		ModelAndView mav = new ModelAndView();
		AdminException adminException = new AdminException("관리자 인증이 필요한 서비스입니다.");
		mav.addObject("e", adminException);
		mav.setViewName("admin/error/result");	
	return mav;
	}
}
