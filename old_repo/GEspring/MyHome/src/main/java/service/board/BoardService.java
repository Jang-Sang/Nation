package service.board;

import java.util.List;
import java.util.Map;

import dao.board.BoardDAO;
import dao.boardfiles.BoardFilesDAO;
import dao.member.MemberDAO;
import vo.board.BoardVO;
import vo.boardfiles.BoardFilesVO;

public class BoardService {

	public BoardDAO boardDao;
	public MemberDAO memberDao;
	public BoardFilesDAO boardFilesDao;
	
	public void setBoardDao(BoardDAO boardDao) {
		this.boardDao = boardDao;
	}
	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}
	public void setBoardFilesDao(BoardFilesDAO boardFilesDao) {
		this.boardFilesDao = boardFilesDao;
	}
	
	public List<BoardVO> selectList(Map<String, Object> map){
		List<BoardVO> list = boardDao.selectList(map);
		
		if(list.isEmpty()) {
			System.out.println(list);
			list = null;
		}
		
		return list;
	}
	
	public BoardVO selectOne(int seq) {
		return boardDao.selectOne(seq);
	}
	
	public int getTotal(Map<String, Object> map) {
		return boardDao.getTotal(map);
	}
	
	public int insert(BoardVO vo) {
		if(vo.getGroupno() != 0) {
			boardDao.updateOrderno(vo);
		}
		int check = boardDao.insert(vo);
				
		return check;
	}
	
	
	public void fileInsert(int seq,List<String> fileList) {
		for(String filename : fileList) {
			boardFilesDao.insert(new BoardFilesVO(seq,filename));
		}
	}
	
	public List<BoardFilesVO> fileSelectList(int seq){
		return boardFilesDao.selectList(seq);
	}
	
	public int getSeq() {
		return boardDao.getSeq();
	}
	
}





















