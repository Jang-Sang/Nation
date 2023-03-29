package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.BoardService;

//@Component - Repository,Service,Controller의 부모 클래스...
//- 용도에 맞게 Compnent보다는 용도에 맞는 클래스를 적는것을 권장한다..
//@Repository
//@Service
//@Controller

@Controller //해당클래스가 Controller라는것을 인식시킨다.
public class BoardController {

	private BoardService service;
	
	public void setService(BoardService service) {
		System.out.println("--- setService(service) ---");
		this.service = service;
	}
	
	public BoardController() {
		System.out.println("--- BoardController() ---");
	}
	
	//Spring 에서는 method마다 url mapping을 한다....
	//@RequestMapping("url")
	@RequestMapping("/board/list")
	public String list(Model model) {
		//String 반환 - View정보...넘어갈 페이지의 정보
		
		List<String> list = service.selectList();
		
		//Model - 인터페이스
		// - Servlet과 Controller의 중간 매개체 역할
		// - request영역과 binding 처리가 되어 있다.
		// - model에 Attribute를 저장하면 request영역에 저장하게 된다...
		
		//request.setAttribute()와 같은 역할..
		model.addAttribute("list", list);
		
		
		return "list"; // /WEB-INF/views/list.jsp로 전달된다...Forward
	}
}

























