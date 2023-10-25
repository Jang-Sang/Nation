<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	int java = Integer.parseInt(request.getParameter("java"));
	int jsp = Integer.parseInt(request.getParameter("jsp"));
	int spring = Integer.parseInt(request.getParameter("spring"));
	
	double avg = (java + jsp + spring) / 3.0;
	
	DecimalFormat df = new DecimalFormat("00.00");
	
	String sa = df.format(avg);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table border="1">
			<tr>
				<th>Name</th>
				<td><%=name %></td>
			</tr>
			<tr>
				<th>Java</th>
				<td><%=java %></td>
			</tr>
			<tr>
				<th>JSP</th>
				<td><%=jsp %></td>
			</tr>
			<tr>
				<th>Spring</th>
				<td><%=spring %></td>
			</tr>
			<tr>
				<th>Average</th>
				<td><%=sa %></td>
			</tr>
			<tr>
				<th colspan="2">
					<%if(avg >= 60) {%>
						합격!
					<%}else { %>
						불합격!
					<%} %>
				</th>
			</tr>
			<tr>
				<td colspan="2">
					<button onclick="history.back()">돌아가기</button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>