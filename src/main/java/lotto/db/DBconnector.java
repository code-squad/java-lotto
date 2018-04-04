package lotto.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnector {

	private static DBconnector instance;

	public Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/java_lotto?serverTimezone=UTC&useSSL=false";
		String id = "durin93";
		String pw = "durin93";
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}

	public static DBconnector getInstance() {
		if (instance == null) {
			instance = new DBconnector();
		}
		return instance;
	}

}