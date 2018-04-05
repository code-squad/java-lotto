package domain;

import java.sql.Connection;
import java.sql.DriverManager;

public class LottoDAO {

    public Connection getConnection() {
        String addr="jdbc:mysql://localhost:3306/lottodb";
        String user="larryjung";
        String pw="db1004";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(addr, user, pw);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



}
