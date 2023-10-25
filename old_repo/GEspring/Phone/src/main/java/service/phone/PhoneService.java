package service.phone;

public class PhoneService {

	private PhoneDAO phoneDao;
	
	public void setMemberDao(PhoneDAO phoneDao) {
		this.phoneDao = phoneDao;
	}
	
	public int insert(PhoneVO vo) {
		return phoneDao.insert(vo);
	}
	
	public int update(PhoneVO vo) {
		return phoneDao.update(vo);
	}
	
	public int delete(int no) {
		return phoneDao.delete(no);
	}
	
	public PhoneVO selectOne(int no) {
		return phoneDao.selectOne(no);
	}

	public String getName(int no) {
		return phoneDao.getName(no);
	}
	
}

