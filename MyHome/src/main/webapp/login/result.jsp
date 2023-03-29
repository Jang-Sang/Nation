<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");
	boolean check = (boolean)request.getAttribute("check");
%>
<%@ include file="/layout/header.jsp" %>
	<%=msg %><br>
	<%if(check) {%>
		<a href="/MyHome/member/myPage.me">MyPage</a> | 회원탈퇴
	<%}else {%>
		<a href="/MyHome/login/findForm.do?mode=id">ID찾기</a> | 
		<a href="/MyHome/login/findForm.do?mode=pw">PW찾기</a> | 
		<a href="/MyHome/login/login.do">Login</a>
	<%} %>
<%@ include file="/layout/footer.jsp" %>


		
		