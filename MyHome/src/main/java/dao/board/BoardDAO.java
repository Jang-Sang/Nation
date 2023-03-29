package dao.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import common.Paging;
import vo.board.BoardVO;

public class BoardDAO {

	private SqlSession sqlSession;
	
	public BoardDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	public List<BoardVO> selectList(Map<String, Object> map){
		return sqlSession.selectList("board.selectList", map);
	}
	
	public BoardVO selectOne(int seq) {
		return sqlSession.selectOne("board.selectOne",seq);
	}
	
	public int getTotal(Map<String, Object> map) {
		return sqlSession.selectOne("board.getTotal",map);
	}
	
	public int insert(BoardVO vo) {
		return sqlSession.insert("board.insert",vo);
	}
	
	public int updateOrderno(BoardVO vo) {
		return sqlSession.update("board.updateOrderno",vo);
	}
	
	public int getSeq() {
		return sqlSession.selectOne("board.getSeq");
	}
	
	public int setGroupno(BoardVO vo) {
		return sqlSession.update("board.setGroupno",vo);
	}
}
