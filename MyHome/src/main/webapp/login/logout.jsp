<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	////session.removeAttribute("login"); 하나 삭제
	//
	//session.invalidate(); // 세션 초기화 // 전체 삭제
    //
	//session = request.getSession(); //현재 페이지에서 세션을 다시 이용할때 기존 세션 정보를 다시 넣어주어야 한다...
	//
	////session.getAttribute("login");
	//
	//out.println("<script type='text/javascript'>");
	//out.println("alert('로그아웃 되었습니다.');");
	//out.println("location.href='/MyHome/index.jsp';");
	//out.println("</script>");
%>

<script>
	alert('${msg}');
	location.href = '${url}';
</script>