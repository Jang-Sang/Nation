<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script>
	
	function deleteAction() {
		var check = confirm("삭제 하시겠습니까?");
		
		if(!check){
			return;
		}
		
		location.href = '${ pageContext.request.contextPath }/board/delete?seq=${vo.seq}';
	}
	
</script>
<%@include file="/WEB-INF/views/layout/header.jsp"%>
<div align="center">
	<table class="boardTable">
		<tr>
			<th>제목</th>
			<td>${vo.title }</td>
			<th>조회수</th>
			<td>${vo.hit }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${vo.name }</td>
			<th>작성일</th>
			<td>${vo.logtime }</td>
		</tr>
		<tr>
			<td colspan="4">
				${vo.content }
				<hr>
				<c:choose>
					<c:when test="${empty list }">
						첨부된 파일이 없습니다.	
					</c:when>
					<c:otherwise>
						첨부파일<br>
						<c:forEach var="f" items="${list}" varStatus="i">
							${i.count }. <a href="${pageContext.request.contextPath }/board/download/${vo.seq}?fn=${f.filename}" download>${f.filename }</a><br>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				
			</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td colspan="3">
				<img alt="" src="${pageContext.request.contextPath }/resources/upload/${vo.filename}">
				<a href="${pageContext.request.contextPath }/resources/upload/${vo.filename}" download>${vo.filename }</a>
			</td>
		</tr>
	</table>
	<div class="btnBox">
		<c:if test="${login == vo.no }">
			<input type="button" value="수정" onclick="location.href='${ pageContext.request.contextPath }/board/updateForm?seq=${vo.seq}&mode=update'">
			<input type="button" value="삭제" onclick="deleteAction()">
		</c:if>
		<input type="button" value="답글쓰기" onclick="location.href='${ pageContext.request.contextPath }/board/writeReply/${vo.seq}'">
		<input type="button" value="목록" onclick="location.href='${ pageContext.request.contextPath }/board/list'">
	</div>
</div>
<%@include file="/WEB-INF/views/layout/footer.jsp"%>
















