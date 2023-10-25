<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String id = (String)request.getAttribute("id");
	boolean check = (boolean)request.getAttribute("check");
%>
<script type="text/javascript">
	function check(f) {
		if(f.id.value == ""){
			alert("ID를 입력하십시오!");
			f.id.focus();
			return false;
		}else if(f.password.value == ""){
			alert("PW를 입력하십시오!");
			f.password.focus();
			return false;
		}
		
		return true;
	}
</script>
<%@ include file="/layout/header.jsp" %>
	<div align="center">
		<form action="/MyHome/login/check.do" method="post" onsubmit="return check(this)">
			<table>
				<tr>
					<th>ID</th>
					<td><input type="text" name="id" value="<%=id %>"></td>
				</tr>
				<tr>
					<th>PW</th>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<th colspan="2" align="right">
						<span class="ckid">
							<%if(check) {%>
								<input type="checkbox" name="ckid" value="true" checked="checked">
							<%}else { %>
								<input type="checkbox" name="ckid" value="true">
							<%} %>
							<font class="ckid_text">아이디 기억하기</font>
						</span>
						<input type="submit" value="Login">
					</th>
				</tr>
			</table>
		</form>
	</div>
	<a href="/MyHome/login/findForm.do?mode=id">ID찾기</a> | 
	<a href="/MyHome/login/findForm.do?mode=pw">PW찾기</a> 

<%@ include file="/layout/footer.jsp" %>

