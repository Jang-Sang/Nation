<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
 	int x = Integer.parseInt(request.getParameter("x"));
	int y = Integer.parseInt(request.getParameter("y"));

	application.setAttribute("x", 4);
	request.setAttribute("x", 3);
	session.setAttribute("y", y); 
	
	// page -> request -> session -> application
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>
		${param['x'] } + ${param['y'] } = ${param['x'] + param['y'] }<br>
		${param['x'] } - ${param['y'] } = ${param['x'] - param['y'] }<br>
		${param.x } + ${param.y } = ${param.x * param.y }<br>
		${param.x } + ${param.y } = ${param.x / param.y }<br> 
		${requestScope.x } + ${sessionScope.y } = ${x / y }<br> 
	</body>
</html>
