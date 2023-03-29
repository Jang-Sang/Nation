<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//request 객체에 데이터를 저장.....Attribute
	request.setAttribute("name", "김민준");

	//response.sendRedirect("/Hello/move/end.jsp");
	//response.sendRedirect("/Hello/move/end.jsp?name=김민준");
	
	response.sendRedirect("/Hello/move/end.jsp?name=" + URLEncoder.encode("김민준", "UTF-8"));

%>

<!-- <script type="text/javascript">
	document.location.href='/Hello/move/end.jsp?name=김민준';
</script> -->