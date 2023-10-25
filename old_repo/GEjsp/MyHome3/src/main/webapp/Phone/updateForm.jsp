<%@page import="phone.phonedto.PhoneDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	function check(){
		if(document.update.phone_no.value == ""){
			alert("번호를 입력하십시오!");
		}else if(document.update.name.value == ""){
			alert("이름을 입력하십시오!");
		}else if(document.update.c_phone.value == ""){
			alert("회사전화번호를 입력하십시오!");
		}else if(document.update.h_phone.value == ""){
			alert("집전화번호를 입력하십시오!");
		}else if(document.update.s_phone.value == ""){
			alert("휴대폰번호를 입력하십시오!");
		}else{
			document.update.submit();
		}
	}
</script>
<%@include file = "/layout/header.jsp" %>
 	<div align="center">
 		<form action="/MyHome/member/update.me" method="post" name = "update">
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
			 		<td colspan="2" align="right" id="border">
			 			<input type="button" value = "수정" onclick="javascript:check()">
			 			<input type="button" value = "돌아가기" onclick="location.href='/MyHome/phone/myPage.me'">
			 		</td>
			 	</tr>
			 </table>	
 	</form>
 	</div>
<%@include file = "/layout/footer.jsp" %>