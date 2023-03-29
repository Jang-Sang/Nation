package controller.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ViewPath;
import service.member.MemberService;
import vo.member.MemberVO;

@Controller
public class LoginController {

	private MemberService memberService;
	
	public LoginController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/login/loginForm")
	public String loginForm(HttpServletRequest request) {
		
		String id = request.getParameter("id");

		boolean check = false;
		//쿠키
		if(id == null){
			
			Cookie[] cks = request.getCookies();
			
			if(cks != null){
				for(Cookie ck : cks){
					if(ck.getName().equals("ckid")){
						id = ck.getValue();
						check = true;
						break;
					}
				}
			}
			
			if(id == null){
				id = "";
			}
		}
		
		request.setAttribute("id", id);
		request.setAttribute("check", check);
		
		return ViewPath.LOGIN + "form.jsp";
	}
	
	@RequestMapping("/login/check")
	public String loginCheck(MemberVO vo,HttpServletRequest request,HttpServletResponse response) {
		
		int no = memberService.checkLogin(vo);
		
		String msg = null;
		boolean check = false;
		
		if(no != 0){
			msg = vo.getId() + "님이 로그인하셨습니다.";
			check = true;
			
			//session에 로그인 값 저장...
			request.getSession().setAttribute("login", no); // 로그인 처리...
			
			
			
			//아이디 기억하기 체크 유무
			String ckid = request.getParameter("ckid");
			
			Cookie ck = null;
			
			//쿠키파일 읽어 오기...
			Cookie[] cks = request.getCookies();
			
			//기존 쿠키파일 검색
			if(cks != null){
				for(Cookie c : cks){
					if(c.getName().equals("ckid")){
						ck = c;
						break;
					}
				}
			}
			
			if(ckid != null){ //체크 되어 있을때
				if(ck == null){ // 쿠키파일 없을때
					ck = new Cookie("ckid",vo.getId());
					
					//root로 경로 설정
					ck.setPath("/");
				
					//유효시간 설정
					ck.setMaxAge(60*60*24);
				
					//클라이언트에게 쿠키파일 생성
					response.addCookie(ck);
				}else{ //있을때
					if(!ck.getValue().equals(vo.getId())){
						ck.setValue(vo.getId());
						response.addCookie(ck);
					}
				}
			}else{ // 체크 안되어 있을때
				if(ck != null){
					if(ck.getValue().equals(vo.getId())){
						ck.setMaxAge(0);
						response.addCookie(ck);
					}
				}
			}
			
		}else{
			msg = "아이디 혹은 비밀번호가 잘못되었습니다.";	
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("check", check);
		
		
		return ViewPath.LOGIN + "result.jsp";
	}
	
	@RequestMapping("/login/logout")
	public String logout(Model model, HttpSession session) {
		
		session.invalidate();
		
		model.addAttribute("msg", "로그아웃되었습니다.");
		model.addAttribute("url", "/myhome/");
		
		return ViewPath.LOGIN + "logout.jsp";
	}
	
	@RequestMapping("/login/findForm")
	public String findForm() {
		return ViewPath.LOGIN + "findForm.jsp";
	}
	
	@RequestMapping("/login/find")
	public String find(Model model,MemberVO vo,String mode) {
		
		String find = null;
		if(vo.getId() == null){
			find = memberService.findId(vo);
		}else{
			find = memberService.findPw(vo);	
		}
		
		
		boolean check = false;
		if(find != null){
			check = true;
			String re = "";
			for(int i = 0; i < find.length(); i++){
				if(i % 2 == 0){
					re += find.charAt(i);
				}else{
					re += "*";
				}
			}
			
			if(mode.equals("id")){
				model.addAttribute("id", re);
			}else{
				model.addAttribute("password", re);	
			}
		}
		
		model.addAttribute("check", check);
		
		return ViewPath.LOGIN + "findResult.jsp";
	}
}
























