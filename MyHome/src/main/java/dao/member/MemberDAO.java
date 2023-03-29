package dao.member;

import org.apache.ibatis.session.SqlSession;

import vo.member.MemberVO;

public class MemberDAO {
	
	private SqlSession sqlSession;
	
	public MemberDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(MemberVO vo) {
		return sqlSession.insert("member.insert", vo);
	}
	
	public int update(MemberVO vo) {
		return sqlSession.update("member.update",vo);
	}
	
	public int delete(int no) {
		return sqlSession.delete("member.delete",no);
	}
	
	public int checkLogin(MemberVO vo) {
		int su = 0;
		
		try {
			su = sqlSession.selectOne("member.checkLogin",vo);
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		return su;
	}
	
	public MemberVO selectOne(int no) {
		return sqlSession.selectOne("member.selectOne",no);
	}
	
	public String findId(MemberVO vo) {
		return sqlSession.selectOne("member.findId",vo);
	}
	
	public String findPw(MemberVO vo) {
		return sqlSession.selectOne("member.findPw",vo);
	}
	
	public String getId(int no) {
		return sqlSession.selectOne("member.getId",no);
	}
	public String getName(int no) {
		return sqlSession.selectOne("member.getName",no);
	}
	
	public String checkId(String id) {
		return sqlSession.selectOne("member.checkId",id);
	}
	
}
