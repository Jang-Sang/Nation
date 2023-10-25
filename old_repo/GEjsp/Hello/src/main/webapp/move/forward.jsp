<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	//request 객체에 데이터를 저장.....Attribute
	//request.setAttribute("name", "김민준");

	//pageContext.forward("/move/end.jsp");

	//MVC2방식에서 사용
	//RequestDispatcher rd = request.getRequestDispatcher("/move/end.jsp");
	
	//rd.forward(request, response);
	
%>

<jsp:forward page="/move/end.jsp">
	<jsp:param value="김민준" name="name"/>
</jsp:forward>