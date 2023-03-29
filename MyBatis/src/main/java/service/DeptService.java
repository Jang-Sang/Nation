package service;

import java.util.List;
import java.util.Map;

import dao.DeptDAO;
import vo.DeptVO;

public class DeptService {

	private DeptDAO deptDao;
	
	public DeptService(DeptDAO deptDao) {
		this.deptDao = deptDao;
	}
	
	public List<DeptVO> selectList(){
		return deptDao.selectList();
	}
	
	public Map<String, Object> selectOne(int deptno) {
		return deptDao.selectOne(deptno);
	}
	
	public boolean insert(DeptVO vo) {
		vo.setDeptno(deptDao.maxNo() + 1);
		
		boolean check = false;
		
		if(deptDao.insert(vo) != 0) {
			check = true;
		}
		
		return check;
	}
	
	public int update(DeptVO vo) {
		return deptDao.update(vo);
	}
	
	public void delete(int deptno) {
		deptDao.delete(deptno);
	}
	
	
	
}





















