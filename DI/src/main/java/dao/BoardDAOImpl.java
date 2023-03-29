package dao;

import java.util.ArrayList;
import java.util.List;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public int insert(Object ob) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> selectList() {
		//DB접속했다는 가정하...
		List<String> list = new ArrayList<String>();
		
		list.add("감");
		list.add("배");
		list.add("오렌지");
		list.add("용과");
		
		return list;
	}

	@Override
	public int update(Object ob) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int idx) {
		// TODO Auto-generated method stub
		return 0;
	}

}
