package member.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.memberdao.MemberDAO;
import member.memberdto.MemberDTO;
import util.Action;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDTO dto = (MemberDTO)request.getSession().getAttribute("login");
		String password = request.getParameter("password");
		
		String msg = "";
		String url = "";
		
		if(!dto.getPassword().equals(password)){
			msg = "비밀번호가 틀렸습니다.!!이전페이지로....";
			url = "/MyHome/member/deleteForm.me";
		}else{
			MemberDAO dao = MemberDAO.getInstance();
			boolean check = dao.deleteMember(dto.getNo());
			if(check){
				
				//쿠키파일 삭제.
				Cookie[] cks = request.getCookies();
				if(cks != null){
					for(Cookie ck : cks){
						if(ck.getName().equals("ckid")){
							if(ck.getValue().equals(dto.getId())){
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
				url = "/MyHome/";
				
				
			}else{
				msg = "탈퇴실패!!잠시후에 다시 시도하십시오..이전페이지로....";
				url = "/MyHome/member/deleteForm.me";
			}
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		
	}

}
