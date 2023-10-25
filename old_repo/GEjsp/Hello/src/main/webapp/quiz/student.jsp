<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	function check() {
		if(document.f.name.value==""){
			alert("이름을 입력하십시오.");
			document.f.name.focus();
		}else if(document.f.java.value==""){
			alert("Java을 입력하십시오.");
			document.f.java.focus();
		}else if(document.f.jsp.value==""){
			alert("JSP을 입력하십시오.");
			document.f.jsp.focus();
		}else if(document.f.spring.value==""){
			alert("Spring을 입력하십시오.");
			document.f.spring.focus();
		}else{
			document.f.submit();
		}
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="/Hello/quiz/studentResult.jsp" method="post" name="f">
			<table border="1">
				<tr>
					<th>Name</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>Java</th>
					<td><input type="text" name="java"></td>
				</tr>
				<tr>
					<th>JSP</th>
					<td><input type="text" name="jsp"></td>
				</tr>
				<tr>
					<th>Spring</th>
					<td><input type="text" name="spring"></td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="button" onclick="javascript:check()">전송</button>
						<button type="reset">다시</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>