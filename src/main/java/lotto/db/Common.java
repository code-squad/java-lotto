package lotto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Common {

	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/java_lotto?serverTimezone=UTC";
		String id = "durin93";
		String pw = "durin93";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static void close(PreparedStatement pstmt, Connection con) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException sqle) {
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException sqle) {
			}
		}
	}

	public static void excuteUpdate(PreparedStatement pstmt, Connection con, String message) {

	}

}
