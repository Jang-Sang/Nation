<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" isErrorPage="true"%>
<%! //클래스의 멤버를 설정하는 부분
	private int age = 18;

	public void addAge(){
		age++;       
	}
%>
<% //메소드의 실행 내용
	String name = "김민준";
	//int age = 20;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%addAge(); %>
	<%-- <!-- <%addAge(); %> HTML 주석 --> --%>
	<div align="center">
		Hello JSP!!!!<br>
		<%-- 표현식은 print 메소드의 인자값을 적는 부분.... --%>
		이름 : <%=name %><br>
		나이 : <%=age %><br>
		<%if(age >= 20) {%>
			성인
		<%} else {%>
			미성년자
		<%} %>
	</div>
</body>
</html>




























 