<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp" %>
	<div align="center">
		<h3>코드 선택</h3>
		<form action="/Student/select/list.jsp" method="post" name="input">
			<input type="hidden" name="mode" value="code">
			<table>
				<tr>
					<th>코드</th>
					<td>
						<select name = "code">
							<option value="1">학생</option>
							<option value="2">교수</option>
							<option value="3">관리자</option>
						</select>
					</td>
				</tr>
				<tr>
					<th colspan="2" align="right">
						<input type="submit" value="검색">
					</th>
				</tr>
			</table>
		</form>
	</div>
<%@ include file="/layout/footer.jsp" %>














