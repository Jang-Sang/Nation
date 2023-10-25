package dao.phone;

import vo.phone.PhoneVO;

public class PhoneDAO {

private SqlSession sqlSession;
	
	public PhoneDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(PhoneVO vo) {
		return sqlSession.insert("member.insert", vo);
	}
	
	public int update(PhoneVO vo) {
		return sqlSession.update("member.update",vo);
	}
	
	public int delete(int no) {
		return sqlSession.delete("phone.delete",no);
	}
	
	public PhoneVO selectOne(int no) {
		return sqlSession.selectOne("phone.selectOne",no);
	}
	
	public String getName(int no) {
		return sqlSession.selectOne("phone.getName",no);
	}

}


