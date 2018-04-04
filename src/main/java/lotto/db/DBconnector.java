package lotto.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnector {

	private static DBconnector instance;
	private Connection con;
	private String url = "jdbc:mysql://localhost:3306/java_lotto?serverTimezone=UTC&useSSL=false";
	private String id = "durin93";
	private String pw = "durin93";

	private DBconnector() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static Connection getConnection() {
		return getInstance().con;
	}

	public static DBconnector getInstance() {
		if (instance == null) {
			instance = new DBconnector();
		}
		return instance;
	}

}