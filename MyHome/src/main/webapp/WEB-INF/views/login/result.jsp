<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
	${msg }<br>
	<c:choose>
		<c:when test="${check }">
			<a href="${ pageContext.request.contextPath }/member/myPage.me">MyPage</a> | 회원탈퇴
		</c:when>
		<c:otherwise>
			<a href="${ pageContext.request.contextPath }/login/findForm?mode=id">ID찾기</a> | 
			<a href="${ pageContext.request.contextPath }/login/findForm?mode=pw">PW찾기</a> | 
			<a href="${ pageContext.request.contextPath }/login/loginForm">Login</a>
		</c:otherwise>
	</c:choose>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>


		
		