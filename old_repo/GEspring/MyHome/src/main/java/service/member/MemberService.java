package service.member;

import dao.member.MemberDAO;
import vo.member.MemberVO;

public class MemberService {

	private MemberDAO memberDao;
	
	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}
	
	public int insert(MemberVO vo) {
		return memberDao.insert(vo);
	}
	
	public int update(MemberVO vo) {
		return memberDao.update(vo);
	}
	
	public int delete(int no) {
		return memberDao.delete(no);
	}
	
	public int checkLogin(MemberVO vo) {
		return memberDao.checkLogin(vo);
	}
	
	public MemberVO selectOne(int no) {
		return memberDao.selectOne(no);
	}
	
	public String findId(MemberVO vo) {
		return memberDao.findId(vo);
	}
	
	public String findPw(MemberVO vo) {
		return memberDao.findPw(vo);
	}
	
	public String getId(int no) {
		return memberDao.getId(no);
	}
	
	public String getName(int no) {
		return memberDao.getName(no);
	}
	
	public String checkId(String id) {
		return memberDao.checkId(id);
	}
	
}



