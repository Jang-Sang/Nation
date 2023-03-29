package dao;

import java.util.List;

public interface BoardDAO {
	//일반적으로 CRUD의 기능을 정의해 놓는다...
	int insert(Object ob); //create
	List<String> selectList(); // Read
	int update(Object ob); // Update
	int delete(int idx); // Delete
}
