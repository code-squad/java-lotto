package Util;

import java.sql.*;

public class Database {
    public static Connection getConnection() throws Exception{
        String url = "jdbc:mysql://localhost:3306/lotto";
        String id = "lotto";
        String pwd = "9229";
        Class.forName("com.mysql.jdbc.Driver");

        return DriverManager.getConnection(url, id, pwd);
    }
}
