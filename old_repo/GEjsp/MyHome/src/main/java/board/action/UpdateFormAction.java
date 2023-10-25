package board.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.boarddao.BoardDAO;
import util.Action;

public class UpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		Map<String, Object> dto = BoardDAO.getInstance().getContent(seq); 
		
		String content = (String)dto.get("content");
		dto.put("content",content.replaceAll("<br>", "\r\n"));
		
		request.setAttribute("dto", dto);
	}

}
