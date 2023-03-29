package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.action.DeleteAction;
import member.action.JoinAction;
import member.action.UpdateAction;
import util.Action;
import util.ActionForward;

@WebServlet("*.me")
public class MemberController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action action = null;
		ActionForward actionForward = null;
		
		String requestURL = request.getRequestURL().toString();
		
		int s = requestURL.lastIndexOf("/") + 1;
		int e = requestURL.lastIndexOf(".me");
		
		String path = requestURL.substring(s,e);
		
		
		switch(path) {
		case "joinForm":
			actionForward = new ActionForward("/member/joinForm.jsp", false);
			break;
		case "join":
			action = new JoinAction();
			actionForward = new ActionForward("/member/result.jsp", false);
			break;
		case "myPage":
			actionForward = new ActionForward("/member/myPage.jsp", false);
			break;
		case "updateForm":
			actionForward = new ActionForward("/member/updateForm.jsp", false);
			break;
		case "deleteForm":
			actionForward = new ActionForward("/member/deleteForm.jsp", false);
			break;
		case "update":
			action = new UpdateAction();
			actionForward = new ActionForward("/MyHome/member/myPage.me", true); // 이런 경우 redirect를 사용함...
			//근데 우리는 result페이지에서 무엇인가의 수작질을 하기때문에 forward로 보내주는것이 맞음.
			//이런경우 중간에 alert창을 띄워 줄수가 없음...
			//그래서 원래 하던 방식으로 하면
			//actionForward = new ActionForward("/member/result.jsp", false);
			//이렇게 됨.
			break;
		case "delete":
			action =  new DeleteAction();
			actionForward = new ActionForward("/member/result.jsp", false);//update와 동일하게처리해도 되는 부분...
			break;
		}
		
		if(action != null) {
			action.execute(request, response);
		}
		
		if(actionForward.isRedirect()) {
			response.sendRedirect(actionForward.getNextPath());
		}else {
			request.getRequestDispatcher(actionForward.getNextPath()).forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		this.doGet(request, response);
	}
	
}
