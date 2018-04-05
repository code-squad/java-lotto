package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public void insert(User user) throws SQLException {
        String sql = "insert into USERS values(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setString(1, user.getId());
        preparedStatement.setString(2, user.getPw());
        preparedStatement.setString(3, user.getName());
        preparedStatement.setString(4, user.getEmail());
        preparedStatement.setString(4, user.getEmail());
        preparedStatement.setString(4, user.getEmail());

        preparedStatement.executeUpdate();
    }
}
