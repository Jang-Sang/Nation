package com.increpas.param;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vo.PersonVO;

@Controller
public class ParamController {

	public static final String VIEWPATH = "/WEB-INF/views/person/";
	
	//url - /insertForm
	@RequestMapping("/insertForm")
	public String insertForm() {
		return VIEWPATH + "insertForm.jsp";
	}
	
	//낱개로 받기
//	@RequestMapping("/insert1/{idx}")
//	public String insert1(Model model,@PathVariable("idx") int idx, String name,int age,String tel) {
//
//		System.out.println(idx);
//		
//		PersonVO vo = new PersonVO(name, age, tel);
//		
//		model.addAttribute("vo", vo);
//		
//		
//		return VIEWPATH + "insertResult.jsp";
//	}
	
	
//	@RequestMapping("/insert1")
//	public String insert1(Model model,@RequestParam("tel") String name,int age,String tel) {
//
//		PersonVO vo = new PersonVO(name, age, tel);
//		
//		model.addAttribute("vo", vo);
//		
//		
//		return VIEWPATH + "insertResult.jsp";
//	}
	
//	@RequestMapping("/insert1")
//	public String insert1(Model model,@RequestParam Map<String,Object> vo) {
//
//		//PersonVO vo = new PersonVO(name, age, tel);
//		
//		model.addAttribute("vo", vo);
//		
//		
//		return VIEWPATH + "insertResult.jsp";
//	}
	
//	@RequestMapping("/insert1")
//	public String insert1(Model model,String name,int age,String tel) {
//
//		PersonVO vo = new PersonVO(name, age, tel);
//		
//		model.addAttribute("vo", vo);
//		
//		
//		return VIEWPATH + "insertResult.jsp";
//	}
	
	//객체로 받기
	@RequestMapping(value = "/insert2")
	public String insert2(Model model, /* @ModelAttribute */ PersonVO vo) {
		
		model.addAttribute("vo", vo);
		
		
		return VIEWPATH + "insertResult.jsp";
	}
	
	
	@RequestMapping(value={"/","/insert"} , method = RequestMethod.GET)
	public String insertForm2() {
		return VIEWPATH + "insertForm.jsp";
	}
	
//	@RequestMapping(value = "/insert" , method = RequestMethod.POST)
//	public String insert3(Model model, /* @ModelAttribute */ PersonVO vo) {
//		
//		model.addAttribute("vo", vo);
//		
//		
//		return VIEWPATH + "insertResult.jsp";
//	}
	
	
	@RequestMapping(value = "/insert" , method = RequestMethod.POST)
	public ModelAndView insert3(PersonVO vo) {
		
		// ModelAndView
		// - model과 View 정보를 하나의 객체로 포장해서 전달해주는 클래스
	
		ModelAndView mv = new ModelAndView(/* VIEWPATH + "insertResult.jsp" */);
		
		mv.setViewName(VIEWPATH + "insertResult.jsp");
		
		mv.addObject("vo", vo);
		
		
		return mv;
	}
}
























