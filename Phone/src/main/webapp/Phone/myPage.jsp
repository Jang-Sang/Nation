<%@page import="phone.phonedao.PhoneDAO"%>
<%@page import="phone.phonedto.PhoneDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file = "/layout/header.jsp" %>
<div align="center">
	<table id="table">
		<tr>
			<td id="border">번호</td>
			<td id="border">${Phone_no}</td>
		</tr>
		<tr>
			<td id="border">이름</td>
			<td id="border">${Name}</td>
		</tr>
		<tr>
			<td id="border">회사전화번호</td>
			<td id="border">${C_phone}</td>
		</tr>
		<tr>
			<td id="border">집전화번호</td>
			<td id="border">${H_phone}</td>
		</tr>
		<tr>
			<td id="border">휴대폰전화번호</td>
			<td id="border">${S_phone}</td>
		</tr>
		<tr>
			<td colspan="2" align="right"  id="border">
				<input type="button" value = "수정" onclick="location.href = '/MyHome/phone/updateForm.me'">
				<input type="button" value = "회원탈퇴" onclick="location.href = '/MyHome/phone/deleteForm.me'">
			</td>
		</tr>
	</table>
</div>
<%@include file = "/layout/footer.jsp" %>