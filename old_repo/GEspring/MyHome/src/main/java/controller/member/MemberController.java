package controller.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import common.ViewPath;
import service.member.MemberService;
import vo.member.MemberVO;

@Controller
public class MemberController {

	private MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/member/joinForm")
	public String joinForm() {
		return ViewPath.MEMBER + "joinForm.jsp";
	}
	
	@RequestMapping("/member/join")
	public String join(Model model,MemberVO vo) {
		int su = memberService.insert(vo);
		
		String url = null;
		String msg = null;
		
		if(su != 0){
			msg = "회원가입 성공!..로그인페이지로..";
			url = "/MyHome/login/loginForm?id=" + vo.getId();		
			//url = "/myhome/";
		}else{
			msg = "회원가입 실패!..이전페이지로..";
			url = "history.back()";		
		}
		
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		
		return ViewPath.MEMBER + "result.jsp";
	}
	
	@RequestMapping("/member/mypage")
	public String myPage(HttpServletRequest request) {
		
		Integer no = (Integer)request.getSession().getAttribute("login");
		
		if(no == null) {
			return "redirect:/login/loginForm";
		}
		
		MemberVO vo = memberService.selectOne(no);
		
		request.setAttribute("vo", vo);
		
		return ViewPath.MEMBER + "myPage.jsp";
	}
	
	@RequestMapping("/member/updateform")
	public String updateForm(HttpServletRequest request) {
		
		Integer no = (Integer)request.getSession().getAttribute("login");
		
		if(no == null) {
			return "redirect:/login/loginForm";
		}
		
		MemberVO vo = memberService.selectOne(no);
		
		request.setAttribute("vo", vo);
		
		return ViewPath.MEMBER + "updateForm.jsp";
	}
	
	@RequestMapping("/member/deleteform")
	public String deleteForm(HttpServletRequest request) {
		
		Integer no = (Integer)request.getSession().getAttribute("login");
		
		if(no == null) {
			return "redirect:/login/loginForm";
		}
		
		String id = memberService.getId(no);
		
		request.setAttribute("id", id);
		
		return ViewPath.MEMBER + "deleteForm.jsp";
	}
	
	@RequestMapping("/member/update")
	public String update(HttpServletRequest request,MemberVO vo) {
		
		Integer no = (Integer)request.getSession().getAttribute("login");
		
		if(no == null) {
			return "redirect:/login/loginForm";
		}
		
		vo.setNo(no);
		
		int check = memberService.update(vo);
		
		
		String msg = null;
		String url = null;
		
		if(check != 0){
			msg = "수정완료!!MyPage로...";
			url = "/myhome/member/mypage";
		}else{
			msg = "수정실패!!이전페이지로...";
			url = "/myhome/member/updateform";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		
		
		return ViewPath.MEMBER + "result.jsp";
	}
	
	@RequestMapping("/member/delete")
	public String delete(HttpServletRequest request,String password,HttpServletResponse response) {
		Integer no = (Integer)request.getSession().getAttribute("login");
		
		if(no == null) {
			return "redirect:/login/loginForm";
		}
		
		MemberVO vo = memberService.selectOne(no);
		
		String msg = "";
		String url = "";
		
		if(!vo.getPassword().equals(password)){
			msg = "비밀번호가 틀렸습니다.!!이전페이지로....";
			url = "/myhome/member/deleteform";
		}else{
			int check = memberService.delete(no);
			if(check != 0){
				
				//쿠키파일 삭제.
				Cookie[] cks = request.getCookies();
				if(cks != null){
					for(Cookie ck : cks){
						if(ck.getName().equals("ckid")){
							if(ck.getValue().equals(vo.getId())){
								ck.setMaxAge(0);
								ck.setPath("/");
								response.addCookie(ck);
								break;
							}
						}
					}
				}
			
				request.getSession().invalidate();
				msg = "탈퇴성공!!!인덱스페이지로...";
				url = "/myhome/";
				
				
			}else{
				msg = "탈퇴실패!!잠시후에 다시 시도하십시오..이전페이지로....";
				url = "/myhome/member/deleteform";
			}
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return ViewPath.MEMBER + "result.jsp";
	}
	
	@RequestMapping(value = "/member/checkId"/* ,produces = "application/text;charset=utf8" */)
	@ResponseBody //데이터 자체를 클라이언트에게 전달하겠다..
	public String checkId(String id) {
		System.out.println(id);
		
		if(memberService.checkId(id) != null) {
			return "이미 사용중인 ID입니다";
		}else{
			return "사용 가능한 ID입니다";
		}
	}
}


















