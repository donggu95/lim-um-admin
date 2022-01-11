package com.koreait.matjip.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.matjip.domain.Restrt;
import com.koreait.matjip.model.category.CategoryService;
import com.koreait.matjip.model.restrt.RestrtService;
import com.koreait.matjip.util.Pager;


//관리자의 맛집과 관련된 요청을 처리하는 하위 컨트롤러
@Controller
public class RestrtController{
		
	@Autowired
	private RestrtService restrtService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private Pager pager;
	
	//맛집 목록 요청
	@GetMapping("/matjip/list")
	public String getList(HttpServletRequest request, Model model) {
		List restrtList = restrtService.selectAll();
		pager.init(restrtList, request);

		model.addAttribute("restrtList", restrtList);
		model.addAttribute("pager", pager);
		
		return "admin/matjip/list";
	}
	
	//맛집 등록 폼 요청
	@GetMapping("/restrt/registform")
	public String registForm(Model model) {
		List restrtList=restrtService.selectAll();//3단계: 카테고리 목록 가져오기
		model.addAttribute("restrtList", restrtList);//4단계:저장
		
		return "admin/restrt/registform";
	}
	
	@RequestMapping(value="/restrt/regist", method=RequestMethod.POST)
	public String regist(Restrt restrt) {
		
		//db 넣기
		restrtService.regist(restrt); //restrt 테이블
		
		
		return "redirect:/admin/restrt/listRestrt";
	}
	
}