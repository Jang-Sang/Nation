<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="/Hello/Test/TestResult.jsp" method="post">
			<table border="1" cellspacing="0">
				<tr>
					<th>이름</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type="text" name="age"></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="전송">
						<input type="reset" value="다시">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>