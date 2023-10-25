package member.memberdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import member.memberdto.MemberDTO;

public class MemberDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//singleton 패턴
	// - 프로그램에서 단 하나의 인스턴스공간만 만들어지도록 작성하는 패턴...
	// - 프로그램 전반적인 부분에서 객체를 매번 생성해서 사용하는것이 아니라
	//   만들어진 인스턴스 공간을 가져다가 바로바로 사용할수 있도록 만든 패턴...
	
//	private static MemberDAO instance = new MemberDAO();
//	
//	public static MemberDAO getInstance() {
//		return instance;
//	}

	private static MemberDAO instance;
	
	public static MemberDAO getInstance() {
		if(instance == null) {
			instance = new MemberDAO();
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
	
//	private MemberDAO() {
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//		}catch(ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	private void getConnection() {
//		String url = "jdbc:oracle:thin:@192.168.12.61:1521:xe";
//		String user = "c##jsp";
//		String password = "jsp";
//		
//		try {
//			con = DriverManager.getConnection(url, user, password);
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	public boolean join(MemberDTO dto) {
		boolean check = false;
		
		String sql = "insert into member values(member_seq.nextval,?,?,?,?,?,?,?)";
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPassword());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getEmail());
			ps.setString(5, dto.getTel1());
			ps.setString(6, dto.getTel2());
			ps.setString(7, dto.getTel3());
			if(ps.executeUpdate() != 0) {
				check = true;
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
		
		return check;
	}
	
	private MemberDTO makeDTO(ResultSet rs) throws SQLException {
		
		if(rs.next()) {
			int no = rs.getInt("no");
			String id = rs.getString("id");
			String password = rs.getString("password");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String tel1 = rs.getString("tel1");
			String tel2 = rs.getString("tel2");
			String tel3 = rs.getString("tel3");
			
			return new MemberDTO(no, id, password, name, email, tel1, tel2, tel3);
			
		}else {
			
			return null;
		}
	}
	
	public MemberDTO checkLogin(MemberDTO dto) {
		
		String sql = "select * from member where id = ? and password = ?";
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPassword());
			rs = ps.executeQuery();
			dto = this.makeDTO(rs);
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
		
		return dto;
	}
	
	
	public String findId(MemberDTO dto) {
		
		String sql = "select id from member where name = ? and tel1 = ? and tel2 = ? and tel3 = ?";
		
		String id = null;
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getTel1());
			ps.setString(3, dto.getTel2());
			ps.setString(4, dto.getTel3());
			rs = ps.executeQuery();
			if(rs.next()) {
				id = rs.getString("id");
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
		
		return id;
	}
	
	public String findPw(MemberDTO dto) {
		
		String sql = "select password from member where id = ? and name = ? and tel1 = ? and tel2 = ? and tel3 = ?";
		
		String pw = null;
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getTel1());
			ps.setString(4, dto.getTel2());
			ps.setString(5, dto.getTel3());
			rs = ps.executeQuery();
			if(rs.next()) {
				pw = rs.getString("password");
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
		
		return pw;
	}	
	
	
	public boolean updateMember(MemberDTO dto) {
		String sql = "update member set email = ?,tel1 = ?,tel2 = ?,tel3 = ? where no = ?";
		boolean check = false;
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getEmail());
			ps.setString(2, dto.getTel1());
			ps.setString(3, dto.getTel2());
			ps.setString(4, dto.getTel3());
			ps.setInt(5, dto.getNo());
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
	
	public boolean deleteMember(int no) {
		String sql = "delete member where no = ?";
		boolean check = false;
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
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






























