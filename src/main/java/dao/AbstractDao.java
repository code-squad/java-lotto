package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class AbstractDao implements Dao {

    public AbstractDao() {}

    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/lottodb";
        String id = "";
        String pw = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, id, pw);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
