<%@page import="phone.phonedao.PhoneDAO"%>
<%@page import="phone.phonedto.PhoneDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	PhoneDTO Phone_no = (PhoneDTO)session.getAttribute("Phone_no");
	//dto.setEmail(request.getParameter("email"));
	//dto.setTel1(request.getParameter("tel1"));
	//dto.setTel2(request.getParameter("tel2"));
	//dto.setTel3(request.getParameter("tel3"));
	
	PhoneDTO dto = new PhoneDTO();
	dto.setPhone_no(Phone.getPhone_no());
	dto.setName(request.getParameter("Name"));
	dto.setC_phone(request.getParameter("C_phone"));
	dto.setH_phone(request.getParameter("H_phone"));
	dto.setS_phone(request.getParameter("S_phone"));
	
	
	boolean check = PhoneDAO.getInstance().updatePhone(dto);
	
	
	String msg = null;
	String url = null;
	
	if(check){
		//session.setAttribute("login", login);
		phone.setEmail(request.getParameter("phone_no"));
		phone.setEmail(request.getParameter("Name"));
		phone.setTel1(request.getParameter("C_phone"));
		phone.setTel2(request.getParameter("H_phone"));
		phone.setTel3(request.getParameter("S_phone"));
		msg = "수정완료!!MyPage로...";
		url = "/MyHome/phone/myPage.jsp";
	}else{
		msg = "수정실패!!이전페이지로...";
		url = "/MyHome/phone/updateForm.jsp";
	}

	request.setAttribute("msg", msg);
	request.setAttribute("url", url);
	
	pageContext.forward("/phone/result.jsp");
	
%>
















