package board.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.boarddao.BoardDAO;
import board.boarddto.BoardDTO;
import util.Action;

public class ContentAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String mode = request.getParameter("mode");
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		if(mode == null) {
			BoardDAO.getInstance().readCount(seq);
		}
		
		Map<String, Object> dto = BoardDAO.getInstance().getContent(seq); 
		
		request.setAttribute("dto", dto);

	}

}
