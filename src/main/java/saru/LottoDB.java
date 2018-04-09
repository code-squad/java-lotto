package saru;

import java.sql.*;

public class LottoDB {
    private static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static LottoDB lottoDB = new LottoDB();
    private String addr;
    private String user;
    private String pw;

    public String getAddr() {
        return addr;
    }

    public String getUser() {
        return user;
    }

    public String getPw() {
        return pw;
    }

    private LottoDB() {
        loadDriver();
    }

    public static LottoDB getInstance() {
        return lottoDB;
    }

    private void loadDriver() {
        try {
            Class.forName(COM_MYSQL_JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("No Driver");
            System.err.println(e.getMessage());
            return;
        }

        System.out.println("Success to load JDBC Driver");
    }

    public void saveConnectInfo(String addr, String user, String pw) {
        this.addr = addr;
        this.user = user;
        this.pw = pw;
    }

    public Connection createConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(addr, user, pw);
            System.out.println("Success to connect");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
