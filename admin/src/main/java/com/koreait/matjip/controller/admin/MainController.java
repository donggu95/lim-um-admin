package com.koreait.matjip.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.matjip.model.category.CategoryService;
import com.koreait.matjip.model.restrt.RestrtService;

@Controller
public class MainController {
	
	@Autowired
	private RestrtService restrtService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public ModelAndView getMain() {
		//카테고리 가져오기
		List categoryList = categoryService.selectAll(); //카테고리 가져오기
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("categoryList", categoryList);
		
		mav.setViewName("matjip/index");
		
		return mav;
	}
	
}
