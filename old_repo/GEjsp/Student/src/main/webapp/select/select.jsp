<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp" %>
<div align="center">
	<button class="button" onclick="document.location.href='/Student/select/nameSelect.jsp'">학생</button>
	<button class="button" onclick="document.location.href='/Student/select/codeSelect.jsp'">교수</button>
	<button class="button" onclick="document.location.href='/Student/select/list.jsp?mode=all'">전체검색</button>
</div>
<%@ include file="/layout/footer.jsp" %>