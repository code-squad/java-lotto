package saru;

import java.sql.*;

public class LottoDB {
    private static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static LottoDB lottoDB;
    private String addr;
    private String user;
    private String pw;

    private LottoDB(String addr, String user, String pw) {
        this.addr = addr;
        this.user = user;
        this.pw = pw;

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

    public static void initLottoDB(String addr, String user, String pw) {
        if (lottoDB == null) {
            lottoDB = new LottoDB(addr, user, pw);
            return;
        }

        System.out.println("이미 초기화 되었습니다.");
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
