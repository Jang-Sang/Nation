<%@page import="member.memberdao.MemberDAO"%>
<%@page import="member.memberdto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	MemberDTO dto = new MemberDTO();
	dto.setId(id);
	dto.setPassword(password);
	
	dto = MemberDAO.getInstance().checkLogin(dto);
	
	String msg = null;
	boolean check = false;
	
	if(dto != null){
		msg = dto.getName() + "님이 로그인하셨습니다.";
		check = true;
		
		//session에 로그인 값 저장...
		session.setAttribute("login", dto); // 로그인 처리...
		
		
		
		//아이디 기억하기 체크 유무
		String ckid = request.getParameter("ckid");
		
		Cookie ck = null;
		
		//쿠키파일 읽어 오기...
		Cookie[] cks = request.getCookies();
		
		//기존 쿠키파일 검색
		if(cks != null){
			for(Cookie c : cks){
				if(c.getName().equals("ckid")){
					ck = c;
					break;
				}
			}
		}
		
		if(ckid != null){ //체크 되어 있을때
			if(ck == null){ // 쿠키파일 없을때
				ck = new Cookie("ckid",dto.getId());
				
				//root로 경로 설정
				ck.setPath("/");
			
				//유효시간 설정
				ck.setMaxAge(60*60*24);
			
				//클라이언트에게 쿠키파일 생성
				response.addCookie(ck);
			}else{ //있을때
				if(!ck.getValue().equals(dto.getId())){
					ck.setValue(dto.getId());
					response.addCookie(ck);
				}
			}
		}else{ // 체크 안되어 있을때
			if(ck != null){
				if(ck.getValue().equals(dto.getId())){
					ck.setMaxAge(0);
					response.addCookie(ck);
				}
			}
		}
		
	}else{
		msg = "아이디 혹은 비밀번호가 잘못되었습니다.";	
	}
	
	request.setAttribute("msg", msg);
	request.setAttribute("check", check);
	
	pageContext.forward("/login/result.jsp");
%>




















