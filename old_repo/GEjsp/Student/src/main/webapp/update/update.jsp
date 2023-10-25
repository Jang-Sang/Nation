<%@page import="student.studentdto.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">

	function check() {
		
		let v = document.getElementById("v").innerText;
		
		if(document.input.name.value === ""){
			alert("이름을 입력하십시오!");
			document.input.name.focus();
		}else if(document.input.value.value === ""){
			alert(v + "을 입력하십시오!");
			document.input.value.focus();
		}else{
			document.input.submit();
		}
	}

</script>
<%@ include file="/layout/header.jsp" %>
	<div align="center">
		<c:if test="${dto == null }">
			<h3>검색 데이터가 없습니다.</h3>
		</c:if>
		<c:if test="${dto != null }">
			<h3>정보 입력</h3>
			<form action="/Student/update/check.jsp" method="post" name="input">
				<table>
					<tr>
						<th>이름</th>
						<td><input type="text" name="name" value="${requestScope.dto.name }" readonly="readonly"></td>
					</tr>
					<tr>
						<th id="v">
							<c:choose>
								<c:when test="${dto.code == 1 }">학번</c:when>
								<c:when test="${dto.code == 2 }">과목</c:when>
								<c:when test="${dto.code == 3 }">부서</c:when>
							</c:choose>
						</th>
						<td><input type="text" name="value" value="${dto.value }"></td>
					</tr>
					<tr>
						<th colspan="2" align="right">
							<input type="button" value="입력" onclick="javascript:check()">
							<input type="reset" value="다시">  
						</th>
					</tr>
				</table>
			</form>
		</c:if>
	</div>
<%@ include file="/layout/footer.jsp" %>