<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println(request.getCharacterEncoding());

	request.setCharacterEncoding("UTF-8");

	//String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String[] name = request.getParameterValues("name");
	
	Map<String,String[]> map = request.getParameterMap();
	
	Enumeration<String> en = request.getParameterNames();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%for(String key : map.keySet()) {%>
		<%=key %> : <%=map.get(key) %><br>
		<%for(String value : map.get(key)) {%>
			<%=value %> | 
		<%} %>
		<br>
	<%} %>
	
	<%while(en.hasMoreElements()) {%>
		<%=en.nextElement() %>
	<%} %>
	<div align="center">
		<table border="1" cellspacing="0">
			<tr>
				<th>이름</th>
				<td><%=name[0] %></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><%=age %></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="button" value="뒤로가기" onclick="location.href='/Hello/Test/Test.jsp'">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>