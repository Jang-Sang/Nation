package dbtest.dbtestdao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import dbtest.dbtestdto.DBTestDTO;

public class DBTestDAO {

	public DBTestDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로딩 성공!");
		} catch (ClassNotFoundException e) {
			System.err.println("로딩 실패!");
			e.printStackTrace();
		}
	}

	private Connection getConnection() {
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##jsp";
		String password = "jsp";
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공!");
		} catch (SQLException e) {
			System.err.println("연결 실패!");
			e.printStackTrace();
		}
		return con;
	}

	public int insert(DBTestDTO dto) {
		Connection con = null;
		PreparedStatement ps = null;
		int su = 0;

		String sql = "insert into dbtest values(?,?,?,sysdate)";
		try {
			con = this.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setInt(2, dto.getAge());
			ps.setDouble(3, dto.getHeight());
			su = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return su;
	}
	
	//delete - 이름을 통하여 삭제
	public boolean delete(String name) {
		
		boolean check = false;
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "delete dbtest where name=?";
		
		try {
			con = this.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			int su = ps.executeUpdate();
			if(su != 0) {
				check = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return check;
	}
	
	
	//update - 기존꺼 가져와서 메소드로
	public int update(DBTestDTO dto) {
		Connection con = null;
		PreparedStatement ps = null;

		int su = 0;
		
		String sql = "update dbtest set age=?,height=? where name=?";
		try {
			con = this.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(3, dto.getName());
			ps.setInt(1, dto.getAge());
			ps.setDouble(2, dto.getHeight());
			su = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return su;
	}
	
	//select
	public void select() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select name,height,age,logtime from dbtest";
		
		try {
			con = this.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
//				String name = rs.getString(1);
//				int age = rs.getInt(2);
//				double height = rs.getDouble(3);
//				Date logtime = rs.getDate(4);

				String name = rs.getString("name");
				int age = rs.getInt("age");
				double height = rs.getDouble("height");
//				Date time = rs.getDate("logtime");
//				
//				SimpleDateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss");
//				String logtime = df.format(time);
		
				String logtime = rs.getString("logtime");
				
				System.out.println(name + "\t" + age + "\t" + height  + "\t" + logtime);
			}
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
	}
}
















