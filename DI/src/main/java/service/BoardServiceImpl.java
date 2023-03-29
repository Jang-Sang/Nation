package service;

import java.util.List;

import dao.BoardDAO;

public class BoardServiceImpl implements BoardService{

	//현재 기능에서 필요한 DAO들을 관리하는 클래스
	private BoardDAO dao;
	
	public BoardServiceImpl(BoardDAO dao) {
		this.dao = dao;
	}	
	
	
	@Override
	public List<String> selectList() {
		return dao.selectList();
	}

}
