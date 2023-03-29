<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table align="center" border="1">
		<caption><font size="5"><b>구 구 단</b></font><br><br></caption>
		<tr>
			<%for(int i = 2; i <= 9; i++) {%>
				<th><%=i %>단</th>
			<%} %>
		</tr>
		<%for(int i = 1; i < 10; i++) {%>
			<tr>
<%-- 					<td><%=j %>×<%=i %>＝<%=j*i %></td> --%>
				<%for(int j = 2; j < 10; j++) {
					out.println(String.format("<td>%d×%d=%d</td>",j,i,j*i));
				} %>
			</tr>
		<%} %>
	</table>
</body>
</html>