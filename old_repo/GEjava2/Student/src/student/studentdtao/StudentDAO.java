package student.studentdtao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import student.studentdto.StudentDTO;

public class StudentDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public StudentDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void getConnection() {
		String url = "jdbc:oracle:thin:@192.168.12.61:1521:xe";
		String user = "c##jsp";
		String password = "jsp";
		
		try {
			con = DriverManager.getConnection(url, user, password);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int insert(StudentDTO dto) {
		
		String sql = "insert into student values(?,?,?)";
		
		int su = 0;
		
		try {
			this.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getValue());
			ps.setInt(3, dto.getCode());
			su = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return su;
	}

	public int delete(String name) {
		int su = 0;
		
		String sql = "delete student where name=?";
		
		try {
			this.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			su = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return su;
	}
	
	public int update(StudentDTO dto) {
		int su = 0;
		
		String sql = "update student set value=? where name=?";
		
		try {
			this.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getValue());
			ps.setString(2, dto.getName());
			su = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return su;
	}
	
	public StudentDTO selectOne(String name) {
		
		StudentDTO dto = null;
		
		String sql = "select * from student where name=?";
		
		try {
			this.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new StudentDTO();
				dto.setName(rs.getString("name"));
				dto.setValue(rs.getString("value"));
				dto.setCode(rs.getInt("code"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}
	
	private ArrayList<StudentDTO> makeList(ResultSet rs) throws SQLException {
		
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		
		while(rs.next()) {
			StudentDTO dto = new StudentDTO();
			dto.setName(rs.getString("name"));
			dto.setValue(rs.getString("value"));
			dto.setCode(rs.getInt("code"));
			
			list.add(dto);
		}
		
		if(list.isEmpty()) {
			list = null;
		}
		
		return list;
	}
	
	public ArrayList<StudentDTO> selectAll() {
		
		
		String sql = "select * from student";
		
		ArrayList<StudentDTO> list = null;
		
		try {
			this.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			list = this.makeList(rs);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public ArrayList<StudentDTO> selectName(String name) {
		
		
		String sql = "select * from student where name like ?";
		
		ArrayList<StudentDTO> list = null;
		
		try {
			this.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			rs = ps.executeQuery();
			list = this.makeList(rs);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public ArrayList<StudentDTO> selectCode(int code) {
		
		
		String sql = "select * from student where code = ?";
		
		ArrayList<StudentDTO> list = null;
		
		try {
			this.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, code);
			rs = ps.executeQuery();
			list = this.makeList(rs);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	
	public ArrayList<StudentDTO> select(StudentDTO dto) {
		
		
		String sql = null;
		
		if(dto == null) {
			sql = "select * from student";
		}else if(dto.getName() != null) {
			sql = "select * from student where name like ?";
		}else {
			sql = "select * from student where code=?";
		}
		
		
		ArrayList<StudentDTO> list = null;
		
		try {
			this.getConnection();
			ps = con.prepareStatement(sql);
			if(dto != null) {
				if(dto.getName()!= null) {
					ps.setString(1, "%" + dto.getName() + "%");
				}else {
					ps.setInt(1, dto.getCode());
				}
			}
			rs = ps.executeQuery();
			list = this.makeList(rs);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
}























