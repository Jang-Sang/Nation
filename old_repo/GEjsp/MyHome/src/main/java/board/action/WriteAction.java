package board.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.boarddao.BoardDAO;
import board.boarddto.BoardDTO;
import member.memberdto.MemberDTO;
import util.Action;

public class WriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		MemberDTO member = (MemberDTO)request.getSession().getAttribute("login");
		
//		int no = member.getNo();
//		String title = request.getParameter("title");
//		String content = request.getParameter("content").replaceAll("\r\n", "<br>");
//		String filename = request.getParameter("filename");
//		
//		BoardDTO dto = new BoardDTO(no, title, content, filename);
		
		String realPath = request.getServletContext().getRealPath("/storage");
		
		//MultipartRequest 객체를 이용하여 파일 업로드...
		
		MultipartRequest mr = new MultipartRequest(request, realPath, 1024 * 1024 * 10, "UTF-8", new DefaultFileRenamePolicy());
		//1. request 객체
	    //2. 서버에 저장할 파일 경로 - 실제경로.
		//3. 최대 파일 크기 - byte단위로.,...
		//4. 인코딩타입
		//5. 파일 덮어쓰기 방지 설정 클래스  - 선택
		
		
		int no = member.getNo();
		String title = mr.getParameter("title");
		String content = mr.getParameter("content").replaceAll("\r\n", "<br>");
		
		
		String filename = mr.getFilesystemName("filename");
		
		//mr.getParameter("filename") - null
		System.out.println(mr.getParameter("filename"));
		//mr.getOriginalFileName("filename") - 실제 업로드된 파일명
		System.out.println(mr.getOriginalFileName("filename"));
		//mr.getFilesystemName("filename") - 실제 저장된 파일명
		System.out.println(mr.getFilesystemName("filename"));
		
		BoardDTO dto = new BoardDTO(no, title, content, filename);
		
		boolean check = BoardDAO.getInstance().write(dto);
		
		request.setAttribute("check", check);
		request.setAttribute("status", "write");
		request.setAttribute("url", "/MyHome/board/list.brd");
		
	}

}



















