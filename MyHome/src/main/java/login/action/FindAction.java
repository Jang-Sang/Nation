package login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.memberdao.MemberDAO;
import member.memberdto.MemberDTO;
import util.Action;

public class FindAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String mode = request.getParameter("mode");

		MemberDTO dto = new MemberDTO();
		
		String id = null;
		if(mode.equals("pw")){
			id = request.getParameter("id");
			dto.setId(id);
		}
		String name = request.getParameter("name");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		
		dto.setName(name);
		dto.setTel1(tel1);
		dto.setTel2(tel2);
		dto.setTel3(tel3);
		
		String find = null;
		if(id == null){
			find = MemberDAO.getInstance().findId(dto);
		}else{
			find = MemberDAO.getInstance().findPw(dto);		
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
				request.setAttribute("id", re);
			}else{
				request.setAttribute("password", re);	
			}
		}
		
		request.setAttribute("check", check);
		
	}
	
}
