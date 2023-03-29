<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp" %>
<script>
	function checkJoin(){
		if(document.join.id.value == ""){
			alert("아이디를 입력하십시오!");
		}else if(document.join.password.value == ""){
			alert("비밀번호를 입력하십시오!");
		}else if(document.join.repw.value == ""){
			alert("비밀번호확인을 입력하십시오!");
		}else if(document.join.name.value == ""){
			alert("이름을 입력하십시오!");
		}else if(document.join.email.value == ""){
			alert("이메일을 입력하십시오!");
		}else if(document.join.tel1.value == ""){
			alert("전화번호를 입력하십시오!");
		}else if(document.join.tel2.value == ""){
			alert("전화번호를 입력하십시오!");
		}else if(document.join.tel3.value == ""){
			alert("전화번호를 입력하십시오!");
		}else if(document.join.password.value != document.join.repw.value){
			alert("비밀번호가 일치하지 않습니다.");
		}else{
			document.join.submit();
		}
	}
	
	function checkId(){
		
		const id = document.getElementById("id");
		
		if(id.value == ""){
			alert("아이디를 입력하십시오!");
			return;
		}
		
		var method = "POST";
		var param = "id=" + encodeURIComponent(id.value);
		var url = "${ pageContext.request.contextPath }/member/checkId"
		sendRequest(url,param,resultCheckId,method);
		
		//JavaScript를 이용하여 서버로 정보를 보내는 HTTP request를 만들기 위해서는 
		//이런 기능을 제공하는 클래스 인스턴스가 필요하다. 

		//이런 클래스는 InternetExplorer에서는 XMLHTTP라고 불리는 ActivX object를 말한다. 

		//그러면 Mozzlia, Safari나 다른 브라우저에서도 Microsoft의 ActiveX 객체의 
		//method와 property를 지원하기 위해 XMLHttpRequest클래스를 구현 하고 있다.

		//if(xhr!=null)return;
		//if(window.ActiveXObject)
			//xhr = new ActiveXObject("Microsoft.XMLHTTP");
		//else
			//xhr = new XMLHttpRequest();		
		
		//httpRequest = new XMLHttpRequest();
		
		//if(!httpRequest){
			//alert("인스턴스 생성 불가!");
			//return;
		//}
		
		//var httpMethod = "GET";
		//var httpParam = "id=" + encodeURIComponent(id.value);
		//var httpURL = "${ pageContext.request.contextPath }/member/checkId?" + httpParam;
		
		
		
		//httpRequest.open(httpMethod,httpURL,true);
		
		//콜백메소드 지정..
		//httpRequest.onreadystatechange = resultCheckId;
		//httpRequest.send();		
	}
	
	function resultCheckId() {
		if(xhr.readyState == 4 && xhr.status == 200){
			
			var data = xhr.responseText;
			const check = document.getElementById("check");
			
			check.innerText = "";
			
			
			alert(data);
			if(data == '사용 가능한 ID입니다'){
				check.style.cssText="color: blue; font-size: 10px;";
			}else{
				check.style.cssText="color: red; font-size: 10px;";				
			}
			
			check.innerText = data;
		}
/* 		if(httpRequest.readyState == 4 && httpRequest.status == 200){
			
			var data = httpRequest.responseText;
			const check = document.getElementById("check");
			
			check.innerText = "";
			
			
			alert(data);
			if(data == '사용 가능한 ID입니다'){
				check.style.cssText="color: blue; font-size: 10px;";
			}else{
				check.style.cssText="color: red; font-size: 10px;";				
			}
			
			check.innerText = data;
		} */
	}
</script>
<form action="${ pageContext.request.contextPath }/member/join" method="post" name = "join">
	<table>
		<tr>
			<td>ID</td>
			<td>
				<input type="text" id="id" name = "id" autocomplete="off">
				<button type="button" onclick="checkId()">중복확인</button><br>
				<span id="check"></span>
			</td>
		</tr>
		<tr>
			<td>PW</td>
			<td><input type="password" name = "password"></td>
		</tr>
		<tr>
			<td>rePW</td>
			<td><input type="password" name = "repw"></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input type="text" name = "name"  autocomplete="off"></td>
		</tr>
		<tr>
			<td>E-Mail</td>
			<td><input type="text" name = "email"></td>
		</tr>
		<tr>
			<td>TEL</td>
			<td>
				<select name = "tel1">
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="016">016</option>
					<option value="019">019</option>
				</select>
				-<input type="text" size = "5" maxlength="4" name = "tel2">
				-<input type="text" size = "5" maxlength="4" name = "tel3">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="Join" onclick="javascript:checkJoin()">
				<input type="button" value="Reset" onclick="document.join.reset()">
			</td>
		</tr>
	</table>
</form>
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>











