<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" isErrorPage="true"%>
<%! //Ŭ������ ����� �����ϴ� �κ�
	private int age = 18;

	public void addAge(){
		age++;       
	}
%>
<% //�޼ҵ��� ���� ����
	String name = "�����";
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
	<%-- <!-- <%addAge(); %> HTML �ּ� --> --%>
	<div align="center">
		Hello JSP!!!!<br>
		<%-- ǥ������ print �޼ҵ��� ���ڰ��� ���� �κ�.... --%>
		�̸� : <%=name %><br>
		���� : <%=age %><br>
		<%if(age >= 20) {%>
			����
		<%} else {%>
			�̼�����
		<%} %>
	</div>
</body>
</html>




























 