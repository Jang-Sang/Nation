package phone.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.memberdao.MemberDAO;
import member.memberdto.MemberDTO;

public class DeleteAction {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Int phone_no = request.getParameter("phone_no");
		
		String msg = "";
		String url = "";
		
		if(!dto.getPhone_no().equals(phone_no)){
			msg = "삭제하지 못했습니다. 이전페이지로...";
			url = "/MyHome/member/deleteForm.me";
		}else{
			PhoneDAO dao =  PhoneDAO.getInstance();
			boolean check = dao.deletePhone(dto.getPhone_no());
			if(check){
				
		
			
				request.getSession().invalidate();
				msg = "삭제성공... 메인페이지로";
				url = "/MyHome/";
				
				
			}else{
				msg = "삭제실패!!잠시후에 다시 시도하십시오..이전페이지로....";
				url = "/MyHome/member/deleteForm.me";
			}
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		
	}

}
