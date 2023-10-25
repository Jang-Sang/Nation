package login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Action;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		
		request.setAttribute("msg", "로그아웃되었습니다...");
		request.setAttribute("url", "/MyHome/");
	}

}
