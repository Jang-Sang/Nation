import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		
		//드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로딩 성공!");
		}catch(ClassNotFoundException e) {
			System.err.println("로딩 실패!");
			e.printStackTrace();
		}
		
		//연결 객체 생성
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##jsp";
		String password = "jsp";
		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공!");
		}catch(SQLException e) {
			System.err.println("연결 실패!");
			e.printStackTrace();
		}
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("키 입력 : ");
		double height = sc.nextDouble();
		
		sc.close();
		
		
		
		//Statement 방식
//		Statement stmt = null;
//		
//		String sql = "insert into dbtest values('" + name + "'," + age + "," + height + ",sysdate)";
//		
//		//System.out.println(sql);
//		
//		try {
//			stmt = con.createStatement();
//			int su = stmt.executeUpdate(sql);
//			
//			if(su != 0) {
//				System.out.println(name + "님의 정보가 추가되었습니다.");
//			}else {
//				System.out.println(name + "님의 정보 추가에 실패하였습니다.");
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(stmt != null) {
//					stmt.close();
//				}
//				if(con != null) {
//					con.close();
//				}
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
		
		//PreparedStatement 방식
		PreparedStatement ps = null;
		
		String sql = "insert into dbtest values(?,?,?,sysdate)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setDouble(3, height);
			int su = ps.executeUpdate();
			
			if(su != 0) {
				System.out.println(name + "님의 정보가 추가되었습니다.");
			}else {
				System.out.println(name + "님의 정보 추가에 실패하였습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}

























