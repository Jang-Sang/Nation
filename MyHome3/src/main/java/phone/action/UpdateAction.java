package phone.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.memberdao.MemberDAO;
import member.memberdto.MemberDTO;
import phone.phonedao.PhoneDAO;
import phone.phonedto.PhoneDTO;
import util.Action;

public class UpdateAction implements Action {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PhoneDTO phone_no = (PhoneDTO)request.getSession().getAttribute("phone_no");
		
		PhoneDTO dto = new PhoneDTO();
		dto.setPhone_no(phone_no.getPhone_no());
		dto.setName(request.getParameter("name"));
		dto.setC_phone(request.getParameter("c_phone"));
		dto.setH_phone(request.getParameter("h_phone"));
		dto.setS_phone(request.getParameter("s_phone"));
		
		
		boolean check = PhoneDAO.getInstance().updatephonebook(dto);
		
		
		String msg = null;
		String url = null;
		
		
		if(check){
			phone_no.setPhone_no(request.getParameter("phone_no"));
			phone_no.setName(request.getParameter("name"));
			phone_no.setC_phone(request.getParameter("c_phone"));
			phone_no.setH_phone(request.getParameter("h_phone"));
			phone_no.setS_phone(request.getParameter("s_phone"));
			msg = "수정완료!!MyPage로...";
			url = "/MyHome/member/myPage.me";
		}else{
			msg = "수정실패!!이전페이지로...";
			url = "/MyHome/member/updateForm.me";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
	}

}
