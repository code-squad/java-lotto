package lotto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LottoDAO {

    public Connection getConnection() {
        String url = "jdbc:mysql://192.168.56.101:3306/lotto";
        String id = "krapeaj";
        String password = "krapeaj";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, id, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
