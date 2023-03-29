import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {

		// 이름을 통하여 나이와 키를 수정하는 코드 작성...
		// 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("로딩 성공!");
		} catch (ClassNotFoundException e) {
			System.err.println("로딩 실패!");
			e.printStackTrace();
		}

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

		Scanner sc = new Scanner(System.in);

		System.out.print("수정할 이름 입력 : ");
		String name = sc.next();
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("키 입력 : ");
		double height = sc.nextDouble();

		sc.close();

//		Statement stmt = null;
//		
//		String sql = String.format("update dbtest set age=%d,height=%f where name='%s'", age,height,name);
//		
//		try {
//			stmt = con.createStatement();
//			int su = stmt.executeUpdate(sql);
//			
//			if(su != 0) {
//				System.out.println(name + "님의 정보가 수정되었습니다.");
//			}else {
//				System.out.println(name + "님의 정보 수정에 실패하였습니다.");
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

		PreparedStatement ps = null;

		String sql = "update dbtest set age=?,height=? where name=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(3, name);
			ps.setInt(1, age);
			ps.setDouble(2, height);
			int su = ps.executeUpdate();

			if (su != 0) {
				System.out.println(name + "님의 정보가 수정되었습니다.");
			} else {
				System.out.println(name + "님의 정보 수정에 실패하였습니다.");
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

	}

}
