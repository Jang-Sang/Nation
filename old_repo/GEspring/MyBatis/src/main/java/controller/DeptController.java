package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import common.ViewPath;
import service.DeptService;
import vo.DeptVO;

@Controller
public class DeptController {

	private DeptService deptService;
	
	public DeptController(DeptService deptService) {
		this.deptService = deptService;
	}
	
	
	@RequestMapping({"/","/list"})
	public String list(Model model) {
		
		List<DeptVO> list = deptService.selectList();
		
		model.addAttribute("list",list);
		
		return ViewPath.DEPT + "list.jsp";
	}
	
	
	@RequestMapping(value = "/insert",method = RequestMethod.GET)
	public String insertForm() {
		return ViewPath.DEPT + "insert.jsp";
	}
	
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	public String insertForm(DeptVO vo) {
		
		boolean check = deptService.insert(vo);
		
		if(check) {
			return "redirect:list";
		}else {
			return "redirect:insert";
		}
	}
	
	@RequestMapping("/update")
	public String update(Model model,DeptVO vo,HttpServletRequest request) {
		String url = "";
		if(request.getMethod().equals("GET")) {
			Map<String, Object> map = deptService.selectOne(vo.getDeptno());
			
			model.addAttribute("vo", map);
			
			url = ViewPath.DEPT + "update.jsp";
			
		}else if(request.getMethod().equals("POST")) {
			if(deptService.update(vo) != 0) {
				url = "redirect:/list";
			}else {
				url = "redirect:update?deptno=" + vo.getDeptno();
			}
		}
		
		return url;
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("deptno") int deptno) {
		
		deptService.delete(deptno);
		
		return "redirect:list";
	}
	
}



























