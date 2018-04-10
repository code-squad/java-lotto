package Util;

import java.sql.*;

public class Database {
    private static Connection conn;
    private static Database database = new Database();

    private Database() {
        createConnection();
    }

    private static Connection createConnection() {
        String url = "jdbc:mysql://localhost:3306/lotto";
        String id = "lotto";
        String pwd = "9229";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, id, pwd);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static Connection getConnection() {
        return conn;
    }
}
