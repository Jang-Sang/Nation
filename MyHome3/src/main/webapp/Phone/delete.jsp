<%@page import="phone.phonedao.PhoneDAO"%>
<%@page import="phone.phonedto.PhoneDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	 String Phone_no = request.getParameter("phone_no");
	
	String msg = "";
	String url = "";
	
	if(!dto.getPhone_no().equals(phone_no)){
		msg = "비밀번호가 틀렸습니다.!!이전페이지로....";
		url = "/MyHome/phone/deleteForm.jsp";
	}else{
		PhoneDAO dao = PhoneDAO.getInstance();
		boolean check = dao.deletePhone(dto.getPhone_no());
		if(check){
			
		
			session.invalidate();
			msg = "탈퇴성공!!!인덱스페이지로...";
			url = "/MyHome/";
			
			
		}else{
			msg = "삭제실패 다시 돌아갑니다";
			url = "/MyHome/phone/deleteForm.jsp";
		}
	}
	
	request.setAttribute("msg", msg);
	request.setAttribute("url", url);
	
	pageContext.forward("/phone/result.jsp");	
%>












