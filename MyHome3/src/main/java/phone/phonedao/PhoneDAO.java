package phone.phonedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import phone.phonedto.PhoneDTO;

public class PhoneDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
private static PhoneDAO instance;
	
	public static PhoneDAO getInstance() {
		if(instance == null) {
			instance = new PhoneDAO();
		}
		return instance;
	}

	//Connection Pool 설정
	private static DataSource ds;
	
	static {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			// java:comp/env/ - Tomcat서버 사용시 설정을 불러오는 경로
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	public boolean updatephonebook(PhoneDTO dto) {
		String sql = "update phonebook set phone_no = ?,name = ?,c_phone = ?,s_phone = ?,h_phone = ?";
		boolean check = false;
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getPhone_no());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getC_phone());
			ps.setString(4, dto.getS_phone());
			ps.setString(5, dto.getH_phone());
			if(ps.executeUpdate() != 0) {
				check = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return check;
	}
	
	
	public boolean deletePhonebook(int phone_no) {
		String sql = "delete phonebook where phone_no = ?";
		boolean check = false;
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, phone_no);
			if(ps.executeUpdate() != 0) {
				check = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return check;
		
	}
	

}
