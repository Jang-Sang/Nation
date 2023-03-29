<%@page import="member.memberdao.MemberDAO"%>
<%@page import="member.memberdto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	//MemberDTO dto = new MemberDTO();
	//dto.setId(request.getParameter("id"));
	//dto.setPassword(request.getParameter("password"));
	//dto.setName(request.getParameter("name"));
	//dto.setEmail(request.getParameter("email"));
	//dto.setTel1(request.getParameter("tel1"));
	//dto.setTel2(request.getParameter("tel2"));
	//dto.setTel3(request.getParameter("tel3"));
%>
<!-- 
	JSP 액션태그
	 - JAVA코드를 대신 적을수 있게 만드는 태그...
	 - useBean - 클래스의 객체를 생성해 주는 태그
	           - 클래스의 디폴트 생성자를 호출한다...
	  - id - 객체명
	  - class - 사용할 클래스의 완전한 경로
	  - scope
	 - setProperty - 객체의 멤버변수의 값을 파라미터 값으로 넘어온데이터를 셋팅해주는 태그
	  - property - 셋팅할 property 명
	  - name - 사용할 객체 명
 -->
 
<jsp:useBean id="dto" class="member.memberdto.MemberDTO"/>
<jsp:setProperty property="*" name="dto"/>
<%	
	MemberDAO dao = MemberDAO.getInstance();
	
	boolean check = dao.join(dto);
	
	out.write("<script>");
	if(check){
		out.write("alert('회원가입 성공!..로그인페이지로..');");
		out.write("location.href='/MyHome/login/login.do?id=" + dto.getId() + "';");		
	}else{
		out.write("alert('회원가입 실패!..이전페이지로..');");
		out.write("history.back();");		
	}
	out.write("</script>");
%>