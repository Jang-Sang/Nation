<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript">

	function check(f) {
		
		if(f.type.value == 'seq'){
			
			var num_pattern = /^[0-9]{1,20}$/;
			
			if(f.word.value=="" || !num_pattern.test(f.word.value)){
				alert("글번호를 입력하십시오!!!");
				return false;
			}
		}
		
		return true;
	}

</script>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
	<c:set var="cpath" value="${ pageContext.request.contextPath }"/>
	<div align="center">
		<table class="boardTable">
			<tr>
				<th>번호</th>
				<th>글제목</th>
				<th>아이디</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:choose>
				<c:when test="${empty list }">
					<tr>
						<td colspan="5" align="center">
							<span style="font-weight: bold;">작성한 글이 없습니다.</span>
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="vo" items="${list }">
						<tr>
							<td>${vo.seq }</td>
							<td>
								<c:forEach var="i" begin="1" end="${vo.depth }" step="1">
									&nbsp;&nbsp;
								</c:forEach>							
								<a href="${ pageContext.request.contextPath }/board/content/${vo.seq }">${vo.title }</a>
							</td>
							<td>${vo.id }</td>
							<td>${vo.logtime }</td>
							<td>${vo.hit }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		<div class="btnBox">
			<form action="${cpath }/board/list" method="get" onsubmit="return check(this)" >
				<span style="float: left;">
					<select name="type">
						<option value="seq" ${param.type == 'seq' ? 'selected' : '' }>글번호로 검색</option>
						<option value="title" ${param.type == 'title' or empty param.type ? 'selected' : '' }>제목으로 검색</option>
						<option value="id" ${param.type == 'id' ? 'selected' : '' }>아이디로 검색</option>
						<option value="content" ${param.type == 'content' ? 'selected' : '' }>내용으로 검색</option>
					</select>
					<input type="text" name="word" placeholder="검색어를 입력하세요" value="${param.word }" autocomplete="off">
					<input class="btn" type="submit"  value="검색">
				</span>
			</form>	
			<c:if test="${login != null }">
					<button onclick="document.location.href='${ pageContext.request.contextPath }/board/writeForm'">글쓰기</button>
			</c:if>
		</div>
		
		<c:if test="${paging.prev }">
			<a href="${cpath }/board/list?page=${paging.begin - 1}">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${paging.begin }" end="${paging.end }" step="1">
			<c:choose>
				<c:when test="${i == paging.page }">
					<strong>[${i }]</strong>
				</c:when>
				<c:otherwise>
					<a href="${cpath }/board/list?page=${i}">[${i }]</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.next }">
			<a href="${cpath }/board/list?page=${paging.end + 1}">[다음]</a>
		</c:if>
		
<%-- 		<c:if test="${nowPage > 2 }">
			<a href="${ pageContext.request.contextPath }/board/list?start=${start - 10 }">[이전]</a>
		</c:if>
		<c:if test="${nowPage > 1 }">
			<a href="${ pageContext.request.contextPath }/board/list?start=${start - 5 }">[${nowPage - 1 }]</a>
		</c:if>
		[${nowPage }]
		<c:if test="${nowPage < totalPage }">
			<a href="${ pageContext.request.contextPath }/board/list?start=${start + 5 }">[${nowPage + 1 }]</a>
		</c:if>
		<c:if test="${nowPage + 1 < totalPage }">
			<a href="${ pageContext.request.contextPath }/board/list?start=${start + 10 }">[다음]</a>
		</c:if> --%>
		
	</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>















