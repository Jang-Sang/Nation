package login.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Action;

public class FormAction implements Action{
	
	public void execute(HttpServletRequest request,HttpServletResponse response) {
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
		
	}
}
