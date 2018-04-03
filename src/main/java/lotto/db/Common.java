package lotto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Common {

	private static Connection dbConn;

	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/java_lotto?serverTimezone=UTC&useSSL=false";
		String id = "durin93";
		String pw = "durin93";

		if (dbConn == null) {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				dbConn = DriverManager.getConnection(url, id, pw);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dbConn;
	}

	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
		if (dbConn != null) {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {

				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException ex) {

				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {

				}
			}
		}
		dbConn = null;
	}

}
