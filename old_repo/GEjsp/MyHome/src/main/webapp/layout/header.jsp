<%@page import="member.memberdto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
//	MemberDTO login = (MemberDTO)session.getAttribute("login");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="/MyHome/resources/css/style.css">
<title>MyHome</title>
</head>
<body>
	<div align="center">
		<div class="header">
			<c:choose>
				<c:when test="${!empty login }"><%--empty -> 없으면 --%>
					<a href="/MyHome/member/myPage.me">MyPage</a> | 
					<a href="/MyHome/login/logout.do">Logout</a> | 					
				</c:when>
				<c:otherwise>
					<a href="/MyHome/login/login.do">Login</a> | 
					<a href="/MyHome/member/joinForm.me">Join</a> |				
				</c:otherwise>
			</c:choose>
	<%-- 		<%if(login != null) {%>
				MyPage | 
				<a href="/MyHome/login/logout.jsp">Logout</a> | 		
			<%} else { %>
				<a href="/MyHome/login/login.jsp">Login</a> | 
				<a href="/MyHome/member/joinForm.jsp">Join</a> | 		
			<%} %> --%>
			<a href="/MyHome/board/list.brd">Board</a> | 
			<a href="/MyHome/">Home</a>
		</div>
		<div class="main">