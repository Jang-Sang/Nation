<%@page import="student.studentdto.StudentDTO"%>
<%@page import="java.util.List"%>
<%@page import="student.studentdtao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mode = request.getParameter("mode");

	StudentDAO dao = StudentDAO.getInstance();

	List<StudentDTO> list = null;
	String title = null;
	
	switch(mode){
	case "all":
		title = "전체";
		list = dao.selectAll();
		break;
	case "name":
		title = "이름";
		String name = request.getParameter("name");
		list = dao.selectName(name);
	case "code":
		title = "코드";
		int code = Integer.parseInt(request.getParameter("code"));
		list = dao.selectCode(code);
	}
	
	
	request.setAttribute("title", title);
	request.setAttribute("list", list);
	
	pageContext.forward("/select/form.jsp");
%>